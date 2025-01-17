package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.Node;

import java.util.ArrayList;
/**
 * The Velocity class controls the speed of the asteroids.
 * 
 * @author TeamMinecraft
 */
public class Velocity {
    private GameStage stage;
    /**
     * The Velocity class controls the speed of the asteroids.
     * 
     * @param stage The GameStage object.
     */
    public Velocity(GameStage stage) {
        this.stage = stage;
    }
    /**
     * moveAsteroid() method controls the speed of the asteroids.
     * The speed of the asteroids increases as the score increases.
     */
    public void moveAsteroid() {
        if (stage.level == 1) {
            speedAsteroids(stage.asteroids.getAsteroids(), 7);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 6);
        } else if (stage.level == 2) {
            speedAsteroids(stage.asteroids.getAsteroids(), 9);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 8);
        } else if (stage.level == 3) {
            speedAsteroids(stage.asteroids.getAsteroids(), 11);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 10);
        } else {
            speedAsteroids(stage.asteroids.getAsteroids(), 14);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 13);
        }
    }
    /**
     * speedAsteroids() method controls the speed of the asteroids.
     * 
     * @param asteroids The ArrayList of asteroids.
     * @param buff      The speed of the asteroids.
     */
    private void speedAsteroids(ArrayList<Node> asteroids, int buff) {
        for (int i = 0; i < asteroids.size(); i++) {
            if (asteroids.get(i).getLayoutX() > -asteroids.get(i).getBoundsInLocal().getWidth() &&
                    asteroids.get(i).getLayoutY() < HelloApplication.H) {
                asteroids.get(i).relocate(asteroids.get(i).getLayoutX(), asteroids.get(i).getLayoutY() + buff);
            } else {
                stage.root.getChildren().remove(asteroids.get(i));
                asteroids.remove(i);
            }
        }
    }
}
