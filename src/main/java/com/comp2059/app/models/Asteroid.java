package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.comp2059.app.models.GameStage.H;
import static com.comp2059.app.models.GameStage.W;

public class Asteroid {
    Image imgAsteroid = new Image(HelloApplication.class.getResource("img/asteroid.png").toExternalForm());
    Image imgBigAsteroid = new Image(HelloApplication.class.getResource("img/big_asteroid.png").toExternalForm());

    private MusicPlayer musicPlayer;
    private GameStage stage;

    public Asteroid(GameStage stage) {
        this.stage = stage;
        musicPlayer = new MusicPlayer();
    }

    public void CreateAsteroid() {
        stage.asteroidCounter++;
        stage.asteroidCounter2++;
        if (stage.level == 1) {
            spawnAsteroids(1, 1);
        } else if (stage.level == 2) {
            spawnAsteroids(2, 1);
        } else if (stage.level == 3) {
            spawnAsteroids(3, 1);
        } else {
            spawnAsteroids(4, 2);
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
