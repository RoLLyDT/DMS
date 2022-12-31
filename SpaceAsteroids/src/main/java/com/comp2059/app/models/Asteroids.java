package com.comp2059.app.models;

import com.comp2059.app.factory.asteroid.IAsteroids;
import javafx.scene.Node;

import java.util.ArrayList;

/**
 * The Asteroids class creates Arraylist for asteroids and big asteroids.
 * 
 * @author TeamMinecraft
 */
public class Asteroids implements IAsteroids<Node> {
    private ArrayList<Node> asteroid = new ArrayList<>();
    private ArrayList<Node> bigAsteroid = new ArrayList<>();

    /**
     * This method adds the asteroids to the Arraylist.
     * 
     * @param node The node of the asteroid.
     */
    @Override
    public void addAsteroid(Node node) {
        asteroid.add(node);
    }

    /**
     * This method adds the big asteroids to the Arraylist.
     * 
     * @param node The node of the big asteroid.
     */
    @Override
    public void addBigAsteroid(Node node) {
        bigAsteroid.add(node);
    }

    /**
     * This method return the asteroid
     * 
     * @return The node of the asteroid.
     */

    @Override
    public ArrayList<Node> getAsteroids() {
        return asteroid;
    }

    /**
     * This method return the big asteroid
     * 
     * @return The node of the big asteroid.
     */
    @Override
    public ArrayList<Node> getBigAsteroids() {
        return bigAsteroid;
    }
}
