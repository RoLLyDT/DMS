package com.comp2059.app.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.comp2059.app.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * HelloController is the controller class for the main menu.
 * It is responsible for the main menu and the game.
 * 
 * @author TeamMinecraft
 */
public class HelloController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * The switchToScene2 method is responsible for the second page of the main
     * menu.
     * 
     * @param event The ActionEvent object.
     */
    public void switchToScene2(ActionEvent event) throws IOException {
        HelloApplication.showSecond(HelloApplication.space);
    }
    /**
     * The switchToScene3 method is responsible for the third page of the main menu.
     * 
     * @param event The ActionEvent object.
     * @throws IOException
     */
    public void switchToScene3(ActionEvent event) throws IOException {
        HelloApplication.showThird(HelloApplication.space);
    }
    /**
     * The switchToScene4 method is responsible for the fourth page of the main menu.
     * 
     * @param event The ActionEvent object.
     * @throws IOException
     */
    public void switchToScene4(ActionEvent event) throws IOException {
        HelloApplication.showFourth(HelloApplication.space);
    }

    @FXML
    private Button Quit;
    // exit program

    @FXML
    private Button Start;

    @FXML
    private Label welcomeText;

    @FXML
    void Quitpressed(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
