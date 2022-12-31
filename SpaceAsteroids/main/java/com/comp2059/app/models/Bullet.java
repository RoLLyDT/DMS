package com.comp2059.app.models;

import static com.comp2059.app.models.GameStage.W;

/**
 * The Bullet class creates the bullets.
 * 
 * @author TeamMinecraft
 */
public class Bullet implements com.comp2059.app.factory.bullet.Bullet {
    GameStage game;

    public Bullet(GameStage gameStage) {
        this.game = gameStage;
    }

    /**
     * This method fires the bullets.
     * 
     * @param deltas The speed of the bullets.
     */
    @Override
    public void fire(int deltas) {
        for (int i = 0; i < game.weapons.size(); i++) {
            if (game.weapons.get(i).getLayoutX() < W) {
                game.weapons.get(i).relocate(game.weapons.get(i).getLayoutX(),
                        game.weapons.get(i).getLayoutY() - deltas);
            } else
                game.weapons.remove(i);
        }
    }
}
