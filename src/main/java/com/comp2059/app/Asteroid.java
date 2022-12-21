package com.comp2059.app;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.comp2059.app.GameStage.H;
import static com.comp2059.app.GameStage.W;

public class Asteroid {
    Image imgAsteroid = new Image(getClass().getResource("img/asteroid.png").toExternalForm());
    Image imgBigAsteroid = new Image(getClass().getResource("img/big_asteroid.png").toExternalForm());

    private MusicPlayer musicPlayer;
    private GameStage stage;

    public Asteroid(GameStage stage) {
        this.stage = stage;
        musicPlayer = new MusicPlayer();
    }

    public void CreateAsteroid() {
        stage.asteroidCounter++;
        stage.asteroidCounter2++;
        if (stage.score < 25) {
            spawnAsteroids(1, 1);
        } else if (stage.score < 60) {
            spawnAsteroids(2, 1);
        } else if (stage.score < 85) {
            spawnAsteroids(3, 1);
        } else {
            spawnAsteroids(4, 1);
        }
    }

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

    private void createNewAsteroid(Image img) {
        double x, randomWidth = 0;
        if (img == imgBigAsteroid)
            x = H;
        else
            x = W;

        Node newAsteroid = new ImageView(img);
        randomWidth = Math.random() * (x - newAsteroid.getBoundsInLocal().getWidth());
        newAsteroid.relocate((int) randomWidth,
                             (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
        if (img == imgBigAsteroid)
            stage.asteroids.addBigAsteroid(newAsteroid);
        else
            stage.asteroids.addAsteroid(newAsteroid);
        stage.root.getChildren().add(newAsteroid);
    }



}
