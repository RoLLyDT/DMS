package com.example.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    Label label = new Label("Space Asteroids");
    Button btnStart = new Button("Start");
    Button btnExit = new Button("Quit");
    Group root = new Group();
    @FXML
    private ChoiceBox<?> Dropdownmenu;

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

    @FXML
    void StartPressed(ActionEvent event) {
        System.out.println("Start pressed");
    }

    @FXML
    void dropdownmenuclicked(MouseEvent event) {

    }

}
