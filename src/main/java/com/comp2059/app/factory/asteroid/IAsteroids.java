package com.comp2059.app.factory.asteroid;

import java.util.List;
/**
 * The IAsteroids interface is used to add asteroids and big asteroids.
 */
public interface IAsteroids<T> {
    public abstract void addAsteroid(T node);
    public abstract void addBigAsteroid(T node);
    public abstract List<T> getAsteroids();
    public abstract List<T> getBigAsteroids();
}
