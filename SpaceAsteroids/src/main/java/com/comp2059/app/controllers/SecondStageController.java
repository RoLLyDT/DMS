package com.comp2059.app.controllers;

import com.comp2059.app.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * The secondstagecontroller class is responsible for the second page of the
 * main menu.
 * 
 * @author TeamMinecraft
 */
public class SecondStageController implements Initializable {
    Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField name;

    @FXML
    /**
     * The switchToGame method is responsible for the game.
     * 
     * @param event
     * @throws IOException
     */
    public void switchToGame(ActionEvent event) throws IOException {
        if (name.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Name is required!", ButtonType.OK);
            alert.show();
            return;
        }
        HelloApplication.showGame();
    }
    /**
     * The switchToScene1 method is responsible for the first page of the main menu.
     * 
     * @param event
     * @throws IOException
     */
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Quitpressed(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
