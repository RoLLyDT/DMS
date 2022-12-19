package com.comp2059.app;

import javafx.scene.Node;

import java.util.ArrayList;

public class Asteroids {
    private ArrayList<Node> asteroid = new ArrayList<>();
    private ArrayList<Node> bigAsteroid = new ArrayList<>();

    public void addAsteroid(Node node) {
        asteroid.add(node);
    }

    public void addBigAsteroid(Node node) {
        bigAsteroid.add(node);
    }

    public ArrayList<Node> getAsteroids() {
        return asteroid;
    }

    public ArrayList<Node> getBigAsteroids() {
        return bigAsteroid;
    }
}
