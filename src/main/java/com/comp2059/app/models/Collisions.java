package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class Collisions {
    private GameStage stage;
    private MusicPlayer musicPlayer;

    public Collisions(GameStage game) {
        this.stage = game;
        musicPlayer = new MusicPlayer();
    }

    public void collide() {
        checkWeaponsAsteroid(stage.asteroids.getAsteroids(), 2, "img/explosion.gif");
        checkWeaponsAsteroid(stage.asteroids.getBigAsteroids(), 4, "img/bigexplosion.gif");
    }

    public void checkWeaponsAsteroid(ArrayList<Node> asteroids, int points, String explosionPath) {
        for (int i = 0; i < stage.weapons.size(); i++) {
            for (int j = 0; j < asteroids.size(); j++) {
                if (stage.weapons.get(i).getBoundsInParent().intersects(asteroids.get(j).getBoundsInParent())) {
                    contactWeaponAsteroid(i, j, points, explosionPath, asteroids);
                    return;
                }
            }
        }
    }

    private void contactWeaponAsteroid(int i, int j, int points, String explosionPath,
            ArrayList<Node> asteroids) {
        Image imgExplosion = new Image(HelloApplication.class.getResource(explosionPath).toExternalForm());
        // add audio here for explosion
        ImageView imgViewExplosion = new ImageView(imgExplosion);
        imgViewExplosion.relocate(asteroids.get(j).getLayoutX(), asteroids.get(j).getLayoutY());
        stage.root.getChildren().remove(asteroids.get(j));
        asteroids.remove(j);
        stage.root.getChildren().add(imgViewExplosion);
        musicPlayer.playExplosion();
        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion
        // doesn't infinitely loop.
        wait.setOnFinished((e) -> {
            stage.root.getChildren().remove(imgViewExplosion);
        });
        wait.play();
        stage.root.getChildren().remove(stage.weapons.get(i));
        stage.weapons.remove(i);
        stage.score += points;

        //level increase per every 50 points
        if (stage.score / 50 > (stage.score - points) / 50 ){
            stage.level++;
            stage.txtlevel.setText("Level: " + stage.level);
        }

        //speed of the shuttle increase by double amount on the 3rd stage
        if (stage.score > 100 && stage.booster < 2) {
            stage.booster++;
            System.out.println(stage.booster);
        }
        stage.txtscore.setText("Score: " + stage.score);
    }
}
