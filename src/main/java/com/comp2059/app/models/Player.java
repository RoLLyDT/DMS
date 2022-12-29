package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * The Player class creates the player.
 * 
 * @author TeamMinecraft
 */
public class Player {
    private GameStage game;
/**
 * This constructor passed gameStage to Player class
 * @param gameStage
 */
    public Player(GameStage gameStage) {
        this.game = gameStage;
    }
 /**
     * This method is used to check if the player has collided with an asteroid.
     * If the player has collided with an asteroid, the game is over.
     */
    public void collide() {
        checkShuttleAsteroid(game.asteroids.getAsteroids(), "img/explosion.gif", "audio/Explosion2.WAV");
        checkShuttleAsteroid(game.asteroids.getBigAsteroids(), "img/bigexplosion.gif", "audio/Explosion2.WAV");
    }
/**
 * This method checks if the player has collided with an asteroid.
 * @param asteroids  Arraylist of asteroids.
 * @param explosionPath Path of the explosion image.
 * @param audioPath Path of the audio file
 */
    private void checkShuttleAsteroid(ArrayList<Node> asteroids, String explosionPath, String audioPath) {
        for (int i = 0; i < game.rocket.size(); i++) {
            for (int j = 0; j < asteroids.size(); j++) {
                if (game.rocket.get(i).getBoundsInParent().intersects(asteroids.get(j).getBoundsInParent())) {
                    contactShuttleAsteroid(i, j, explosionPath, audioPath, asteroids);
                }
            }
        }
    }
/**
 * This method is used to check if the player has collided with an asteroid.
 * @param i
 * @param j
 * @param explosionPath Path of the explosion image.
 * @param audioPath Path of the audio file
 * @param asteroids Arraylist of asteroids.
 */
    private void contactShuttleAsteroid(int i, int j, String explosionPath, String audioPath,
                                        ArrayList<Node> asteroids) {
        game.gameOver = true;
        Image imgExplosion = new Image(HelloApplication.class.getResource(explosionPath).toExternalForm());
        AudioClip audioClip_Explosion = new AudioClip(
                HelloApplication.class.getResource(audioPath).toExternalForm());
        ImageView imgviewExplosion = new ImageView(imgExplosion);
        imgviewExplosion.relocate(game.rocket.get(i).getLayoutX(), game.rocket.get(i).getLayoutY());
        game.root.getChildren().remove(asteroids.get(j));
        PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
        wait.setOnFinished((e) -> {
            game.root.getChildren().remove(imgviewExplosion);
        });
        wait.play();
        asteroids.remove(j);
        game.root.getChildren().add(imgviewExplosion);
        audioClip_Explosion.play();
        game.root.getChildren().remove(game.rocket.get(i));
        game.rocket.remove(i);

        Text txtGameOver = new Text(500, 360, "Gameover!");
        txtGameOver.setFill(Color.RED);
        Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
        txtGameOver.setFont(font3);
        game.root.getChildren().add(txtGameOver);

        Text txtScore = new Text(520, 430, "Final Score: " + game.score);
        txtScore.setFill(Color.RED);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 40);
        txtScore.setFont(font2);
        game.root.getChildren().add(txtScore);

        Button btnQuit = new Button("Quit");
        btnQuit.setScaleX(6);
        btnQuit.setScaleY(4);
        btnQuit.setTextFill(Color.YELLOW);
        btnQuit.setTranslateX(1000);
        btnQuit.setTranslateY(600);
        btnQuit.setStyle("-fx-background-color: red;");
        game.root.getChildren().add(btnQuit);
        btnQuit.setOnAction(e -> Platform.exit());
    }
}
