package com.comp2059.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class HelloController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2(ActionEvent event) throws IOException {
        HelloApplication.showSecond(space);
        // Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        HelloApplication.showThird(space);
    }

    // Group root = new Group();
    @FXML
    private ChoiceBox<String> Dropdownmenu;

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

    String space;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dropdownmenu.getItems().addAll("Background1", "Background2", "Background3");
        Dropdownmenu.setValue("Background1");
        space = "img/background.png";

        Dropdownmenu.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.equals("Background1")) {
                space = "img/background.png";
            } else if (newValue.equals("Background2")) {
                space = "img/background2.png";
            } else if (newValue.equals("Background3")) {
                space = "img/background3.png";
            }
        });
    }
}
