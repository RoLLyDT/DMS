package com.example.demo6;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    Label label = new Label("Space Asteroids");
    Button btnStart = new Button("Start");
    Button btnExit = new Button("Quit");
    // Group root = new Group();
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

    /*
     * @FXML
     * void StartPressed(ActionEvent event) throws IOException {
     * // System.out.println("Start pressed");
     * AnchorPane pane = FXMLLoader.load(getClass().getResource("page2.fxml"));
     * //root.getChildren().setAll(pane);
     * }
     */

    @FXML
    void dropdownmenuclicked(MouseEvent event) {

    }

}
