package com.comp2059.app;

import javafx.scene.image.ImageView;

public class Space {
    ImageView imgbackground = new ImageView(getClass().getResource("img/background.png").toExternalForm());

    private GameStage game;

    public Space(String background, GameStage game) {
        this.game = game;
        imgbackground = new ImageView(getClass().getResource(background).toExternalForm());
    }

    public Space() {
    }

    public void Create() {
        game.root.getChildren().add(imgbackground);
    }
}