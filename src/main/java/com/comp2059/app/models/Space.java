package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.image.ImageView;

public class Space {
    ImageView imgbackground = new ImageView(HelloApplication.class.getResource("img/background.png").toExternalForm());

    private GameStage game;

    public Space(String background, GameStage game) {
        this.game = game;
        imgbackground = new ImageView(HelloApplication.class.getResource(background).toExternalForm());
    }

    public Space() {
    }

    public void Create() {
        game.root.getChildren().add(imgbackground);
    }
}