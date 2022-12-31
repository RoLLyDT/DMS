package com.comp2059.app.factory.asteroid;

import com.comp2059.app.HelloApplication;
import com.comp2059.app.models.GameStage;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * NormalAsteroid class is used to create normal asteroids.
 * @author TeamMinecraft
 */
public class NormalAsteroid implements Asteroid {
    private Image img = new Image(HelloApplication.class.getResource("img/asteroid.png").toExternalForm());
    private GameStage stage;
    public NormalAsteroid(GameStage stage) {
        this.stage = stage;
    }
    /**
     * This method creates the normal asteroids.
     */
    @Override
    public void createAsteroid() {
        stage.asteroidCounter++;
        if (stage.score < 50) {
            spawnAsteroids(1);
        } else if (stage.score < 100) {
            spawnAsteroids(2);
        } else if (stage.score < 150) {
            spawnAsteroids(3);
        } else {
            spawnAsteroids(4);
        }
    }
/**
 * This method spawns the normal asteroids.
 */
    @Override
    public void spawnAsteroids(int cnt) {
        if (stage.asteroidCounter % stage.modifier == 0) {
            for (int i = 0; i < cnt; i++) {
                createNewAsteroid();
            }
        }
    }
/**
 * This method creates new normal asteroids.
 */
    @Override
    public void createNewAsteroid() {
        double x, randomWidth = 0;
        x = HelloApplication.W;

        Node newAsteroid = new ImageView(img);
        randomWidth = Math.random() * (x - newAsteroid.getBoundsInLocal().getWidth());
        newAsteroid.relocate((int) randomWidth,
                (int) (Math.random() / (HelloApplication.W + newAsteroid.getBoundsInLocal().getWidth())));
        stage.asteroids.addAsteroid(newAsteroid);
        stage.root.getChildren().add(newAsteroid);
    }

}
