package com.comp2059.app.models;

import static com.comp2059.app.models.GameStage.W;

public class Bullet {
    GameStage game;
    public Bullet(GameStage gameStage){
        this.game=gameStage;
    }

    public void fire(int deltas) {
        for (int i = 0; i < game.weapons.size(); i++) {
            if (game.weapons.get(i).getLayoutX() < W) {
                game.weapons.get(i).relocate(game.weapons.get(i).getLayoutX(), game.weapons.get(i).getLayoutY() - deltas);
            } else
                game.weapons.remove(i);
        }
    }

}
