package com.comp2059.app.models;

import com.comp2059.app.factory.asteroid.BigAsteroid;
import com.comp2059.app.factory.asteroid.NormalAsteroid;

/**
 * The Asteroid class creates the asteroids and the big asteroids.
 * 
 * @author TeamMinecraft
 */

public class Asteroid {

    private MusicPlayer musicPlayer;
    private GameStage stage;

    /**
     * This constructor passed stage to the Asteroid class
     * 
     * @param stage The stage of the game
     */
    public Asteroid(GameStage stage) {
        this.stage = stage;
        musicPlayer = new MusicPlayer();
    }

    public void CreateAsteroid() {
        com.comp2059.app.factory.asteroid.Asteroid normalAsteroid = new NormalAsteroid(stage),
                bigAsteroid = new BigAsteroid(stage);
        normalAsteroid.createAsteroid();
        bigAsteroid.createAsteroid();
    }

    /**
     * This method create and spawns the asteroids and the big asteroids.
     */

}
