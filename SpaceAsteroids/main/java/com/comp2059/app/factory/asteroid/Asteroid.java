package com.comp2059.app.factory.asteroid;
/**
 * The Asteroid interface is used to create asteroids and spawn asteroids.
 */
public interface Asteroid {
    abstract void createAsteroid();
    abstract void spawnAsteroids(int cnt);
    abstract void createNewAsteroid();
}
