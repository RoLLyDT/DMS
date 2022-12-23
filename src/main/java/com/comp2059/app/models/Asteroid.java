package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.comp2059.app.models.GameStage.H;
import static com.comp2059.app.models.GameStage.W;

/**
 * The Asteroid class creates the asteroids and the big asteroids.
 * @author TeamMinecraft
 */

public class Asteroid {
    Image imgAsteroid = new Image(HelloApplication.class.getResource("img/asteroid.png").toExternalForm());
    Image imgBigAsteroid = new Image(HelloApplication.class.getResource("img/big_asteroid.png").toExternalForm());

    private MusicPlayer musicPlayer;
    private GameStage stage;

    /**
     * This constructor passed the stage to the Asteroid class
     * @param stage The stage of the game
     */
    public Asteroid(GameStage stage) {
        this.stage = stage;
        musicPlayer = new MusicPlayer();
    }

    /**
     * This method create and spawns the asteroids and the big asteroids.
     */
    public void CreateAsteroid() {
        stage.asteroidCounter++;
        stage.asteroidCounter2++;
        if (stage.score < 50) {
            spawnAsteroids(1, 1);
        } else if (stage.score < 100) {
            spawnAsteroids(2, 1);
        } else if (stage.score < 150) {
            spawnAsteroids(3, 1);
        } else {
            spawnAsteroids(4, 2);
        }
    }

    /**
     * This method creates the asteroids and the big asteroids.
     * @param normalCnt The number of normal asteroids.
     * @param bigCnt    The number of big asteroids.
     */
    private void spawnAsteroids(int normalCnt, int bigCnt) {
        if (stage.asteroidCounter % stage.modifier == 0) {
            for (int i = 0; i < normalCnt; i++) {
                createNewAsteroid(imgAsteroid);
            }
        }
        if (stage.asteroidCounter2 % stage.modifier == 0) {
            for (int i = 0; i < bigCnt; i++) {
                createNewAsteroid(imgBigAsteroid);
            }
        }
    }

    /**
     * This method create image of the asteroids and the big asteroids.
     * @param img The image of the asteroids and the big asteroids.
     */
    private void createNewAsteroid(Image img) {
        double x, randomWidth = 0;
        if (img == imgBigAsteroid)
            x = HelloApplication.H;
        else
            x = HelloApplication.W;

        Node newAsteroid = new ImageView(img);
        randomWidth = Math.random() * (x - newAsteroid.getBoundsInLocal().getWidth());
        newAsteroid.relocate((int) randomWidth,
                (int) (Math.random() / (HelloApplication.W + newAsteroid.getBoundsInLocal().getWidth())));
        if (img == imgBigAsteroid)
            stage.asteroids.addBigAsteroid(newAsteroid);
        else
            stage.asteroids.addAsteroid(newAsteroid);
        stage.root.getChildren().add(newAsteroid);
    }

}
