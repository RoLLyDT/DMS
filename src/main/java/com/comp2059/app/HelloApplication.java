package com.comp2059.app;

import com.comp2059.app.models.GameStage;
import com.comp2059.app.models.MusicPlayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The HelloApplication class is the main class of the application.
 * It is responsible for the main menu and the game.
 * 
 * @author TeamMinecraft
 */
public class HelloApplication extends Application {
    private static Stage stage;
    public static String space = "img/background.png";
    public static int W = 1200, H = 720;
    /**
     * The start() method is responsible for the main menu.
     * 
     * @param stage The Stage object.
     * @throws IOException
     */

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showMenu();
    }
    /**
     * The showMenu() method is responsible for the main menu.
     * 
     * @throws IOException
     */
    public static void showMenu() throws IOException {
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, W, H, Color.BLACK);
        stage.setScene(scene);
        stage.show();
        new MusicPlayer().playClip(true);
    }
    /**
     * The showSecond method is responsible for the second page of the main menu.
     * 
     * @param s The String object.
     * @throws IOException
     */
    public static void showSecond(String s) throws IOException {
        space = s;
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("page2.fxml"));
        Scene scene = new Scene(root, W, H, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
     /**
     * The showThird method is responsible for the third page of the main menu.
     * 
     * @param s The String object.
     * @throws IOException
     */
    public static void showThird(String s) throws IOException {
        space = s;
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("page3.fxml"));
        Scene scene = new Scene(root, W, H, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * The showFourth method is responsible for the fourth page of the main menu.
     * 
     * @param s
     * @throws IOException
     */
    public static void showFourth(String s) throws IOException {
        space = s;
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("page4.fxml"));
        Scene scene = new Scene(root, W, H, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * The showGame method is responsible for the game.
     * 
     * @throws IOException
     */
    public static void showGame() {
        GameStage gameStage = new GameStage(stage, space);
        gameStage.show();
    }
    /**
     * The main method is responsible for the main menu.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}