package com.comp2059.app.factory.asteroid;

import com.comp2059.app.HelloApplication;
import com.comp2059.app.models.GameStage;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * The BigAsteroid class creates the big asteroids.
 * @author TeamMinecraft
 */
public class BigAsteroid implements Asteroid {
    private Image img = new Image(HelloApplication.class.getResource("img/big_asteroid.png").toExternalForm());

    private GameStage stage;
/**
 * This constructor passed game to the BigAsteroid class
 * @param gameStage
 */
    public BigAsteroid(GameStage gameStage) {
        this.stage = gameStage;
    }
/**
 * This method creates the big asteroids.
 */
    @Override
    public void createAsteroid() {
        stage.asteroidCounter2++;
        if (stage.score < 50) {
            spawnAsteroids(1);
        } else if (stage.score < 100) {
            spawnAsteroids(1);
        } else if (stage.score < 150) {
            spawnAsteroids(1);
        } else {
            spawnAsteroids(2);
        }
    }
/**
 * This method spawns the big asteroids.
 */
    @Override
    public void spawnAsteroids(int cnt) {
        if (stage.asteroidCounter2 % stage.modifier == 0) {
            for (int i = 0; i < cnt; i++) {
                createNewAsteroid();
            }
        }
    }
/**
 * This method creates new big asteroids.
 */
    @Override
    public void createNewAsteroid() {
        double x, randomWidth = 0;
        x = HelloApplication.H;

        Node newAsteroid = new ImageView(img);
        randomWidth = Math.random() * (x - newAsteroid.getBoundsInLocal().getWidth());
        newAsteroid.relocate((int) randomWidth,
                (int) (Math.random() / (HelloApplication.W + newAsteroid.getBoundsInLocal().getWidth())));
        stage.asteroids.addBigAsteroid(newAsteroid);
        stage.root.getChildren().add(newAsteroid);
    }
}
