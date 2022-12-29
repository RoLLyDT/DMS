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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * The optionscontroller class is responsible for the options page.
 * 
 * @author TeamMinecraft
 */
public class OptionsController implements Initializable {
    Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField name;
/**
     * The switchToScene1 method is responsible for the first page of the main menu.
     * 
     * @param event The ActionEvent object.
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
    private ChoiceBox<String> Dropdownmenu;


    @FXML
    void dropdownmenuclicked(MouseEvent event) {
    }

    /**
     * The initialize method is responsible for the initialisation of the options
     * page.
     * 
     * @param url            The URL object.
     * @param resourceBundle The ResourceBundle object.
     * @throws IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dropdownmenu.getItems().addAll("Background1", "Background2", "Background3");
        Dropdownmenu.setValue("Background");

        Dropdownmenu.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.equals("Background1")) {
                HelloApplication.space = "img/background.png";
            } else if (newValue.equals("Background2")) {
                HelloApplication.space = "img/background2.png";
            } else if (newValue.equals("Background3")) {
                HelloApplication.space = "img/background3.png";
            }
        });
    }
}
