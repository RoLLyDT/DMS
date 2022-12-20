package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    private static String space;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showMenu();
    }

    public static void showMenu() throws IOException {
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new MusicPlayer().playClip(true);

    }

    public static void showSecond(String s) throws IOException {
        space = s;
        stage.setTitle("Space Asteroids");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("page2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showGame() {
        GameStage gameStage=new GameStage(stage,space);
        gameStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}