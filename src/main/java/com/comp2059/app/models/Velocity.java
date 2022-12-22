package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.Node;

import java.util.ArrayList;

public class Velocity {
    private GameStage stage;

    public Velocity(GameStage stage) {
        this.stage = stage;
    }

    public void moveAsteroid() {
        if (stage.score < 40) {
            speedAsteroids(stage.asteroids.getAsteroids(), 7);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 6);
        } else if (stage.score < 70) {
            speedAsteroids(stage.asteroids.getAsteroids(), 9);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 8);
        } else if (stage.score < 100) {
            speedAsteroids(stage.asteroids.getAsteroids(), 11);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 10);
        } else {
            speedAsteroids(stage.asteroids.getAsteroids(), 14);
            speedAsteroids(stage.asteroids.getBigAsteroids(), 13);
        }
    }

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
