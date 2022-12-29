package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.image.ImageView;

/**
 * The Space class creates the background of the game.
 * @author TeamMinecraft
 */
public class Space {
    ImageView imgbackground = new ImageView(HelloApplication.class.getResource("img/background.png").toExternalForm());
    /**
     * This constructor passed game to the Space class
     * 
     * @param game       The stage of the game
     * @param background The path of the background image
     */
    private GameStage game;
    /**
     * This constructor passed game to the Space class
     * 
     * @param background The path of the background image
     * @param game       The stage of the game
     */
    public Space(String background, GameStage game) {
        this.game = game;
        imgbackground = new ImageView(HelloApplication.class.getResource(background).toExternalForm());
    }
    /**
     * This constructor passed game to the Space class
     */
    public Space() {
    }
    /**
     * This method creates the background of the game.
     */
    public void Create() {
        game.root.getChildren().add(imgbackground);
    }
}