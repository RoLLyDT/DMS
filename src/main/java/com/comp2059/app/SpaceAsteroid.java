package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.AudioClip; // Importing the audio clip class
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SpaceAsteroid extends Application {
    boolean goUp, goDown, goLeft, goRight, shoot;
    ArrayList<Node> weapons = new ArrayList<>(); // This is an array list that stores the laser beams that are fired
    ArrayList<Node> asteroid = new ArrayList<>();// This array list is used to store spawned small asteroids
    ArrayList<Node> bigAsteroid = new ArrayList<>(); // This array list is used to store spawned big asteroids
    ArrayList<Node> rocket = new ArrayList<>();
    static final double L = 800, W = 1400, H = 820;
    int dShoot = 10;
    Group root = new Group();
    int asteroidCounter = 0;
    int asteroidCounter2 = 0;
    int modifier = 150;
    TextField txtName = new TextField();
    boolean gameOver = false;
    Text txtscore;
    Image imgArtWork = new Image(getClass().getResource("img/artwork.png").toExternalForm()); // Space asteroid logo in
                                                                                              // the main menu
    ImageView viewArtWork = new ImageView(imgArtWork);
    int score = 0; // Score being declared and initialized
    Image imgShuttle = new Image(getClass().getResource("img/shuttle.png").toExternalForm());
    ImageView imgviewShuttle = new ImageView(imgShuttle);
    // add audio to java fx
    AudioClip audioClip = new AudioClip(getClass().getResource("audio/StarWars60.wav").toExternalForm());
    AudioClip audioClip_Laser = new AudioClip(getClass().getResource("audio/Laser.WAV").toExternalForm());

    // Main menu Stage
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Current working directory : " + System.getProperty("user.dir"));
        primaryStage.setTitle("Space Asteroids");
        Label label = new Label("Space Asteroids");
        Button btnStart = new Button("Start");
        Button btnExit = new Button("Quit");
        label.setTextFill(Color.WHITE);
        btnStart.setStyle("-fx-background-color: red;");
        btnExit.setStyle("-fx-background-color: red;");
        btnStart.setScaleX(6);
        btnStart.setScaleY(4);
        btnExit.setScaleX(6);
        btnExit.setScaleY(4);
        btnStart.setTextFill(Color.YELLOW);
        btnExit.setTextFill(Color.YELLOW);
        btnStart.setTranslateX(200);
        viewArtWork.setTranslateX(400);
        viewArtWork.setTranslateY(170);
        btnStart.setTranslateY(600);
        btnExit.setTranslateX(1000);
        btnExit.setTranslateY(600);
        primaryStage.setResizable(false);
        Group root = new Group();
        root.getChildren().add(viewArtWork);
        Font font = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
        label.setTranslateX(430);
        label.setFont(font);
        root.getChildren().add(label);
        root.getChildren().add(btnStart);
        root.getChildren().add(btnExit);
        btnExit.setOnAction(e -> Platform.exit());
        btnStart.setOnAction(e -> {
            secondStage(); //This opens the second stage.
            primaryStage.close();
        });
        Scene scene = new Scene(root, 1200, 720, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        // play audio background music
        int INDEFINITE = -1;
        audioClip.setCycleCount(INDEFINITE);
        audioClip.play();

    }

    Stage stage2;

    // Rules stage, controls explaination stage and the stage where you input your
    // name.
    public void secondStage() {
        stage2 = new Stage();
        stage2.setTitle("Space Asteroids");
        Label label = new Label("Space Asteroids");
        Label lblName = new Label("Please input your Name:");
        Label lblRules = new Label(
                "Rules:You control a space shuttle and asteroids are in your path,  you must avoid them at all costs\n by either dodging them or destroying with your laser beam.\nControls: Left Arrow=Move Left,Right Arrow=Move Right,Up Arrow= Move Up, Down Arrow=Move Down, Space=Fire");
        Button btnQuit = new Button("Quit");
        Button btnPlay = new Button("Play");
        btnPlay.setScaleX(6);
        btnPlay.setScaleY(4);
        btnPlay.setStyle("-fx-background-color: red;");
        btnPlay.setTranslateX(1000);
        btnPlay.setTextFill(Color.YELLOW);
        btnPlay.setTranslateY(600);
        btnQuit.setScaleX(6);
        stage2.setResizable(false);
        btnQuit.setScaleY(4);
        btnQuit.setStyle("-fx-background-color: red;");
        btnQuit.setTranslateX(200);
        btnQuit.setTextFill(Color.YELLOW);
        btnQuit.setTranslateY(600);
        txtName.setTranslateY(400);
        txtName.setPrefWidth(300);
        txtName.setPrefHeight(80);
        txtName.setTranslateX(500);
        txtName.setTranslateY(350);
        label.setTextFill(Color.WHITE);
        lblName.setTextFill(Color.WHITE);
        lblRules.setTextFill(Color.WHITE);
        Group root2 = new Group();
        Font font = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font font4 = Font.font("Segoui UI", FontPosture.REGULAR, 18);
        label.setTranslateX(430);
        lblName.setTranslateY(350);
        lblName.setTranslateX(200);
        lblRules.setTranslateY(200);
        lblRules.setTranslateX(100);
        label.setFont(font);
        lblName.setFont(font2);
        txtName.setFont(font3);
        lblRules.setFont(font4);
        root2.getChildren().add(label);
        root2.getChildren().add(lblName);
        root2.getChildren().add(txtName);
        root2.getChildren().add(lblRules);
        root2.getChildren().add(btnQuit);
        root2.getChildren().add(btnPlay);
        btnQuit.setOnAction(e -> {
            Platform.exit();
        });
        // Validating the textbox
        btnPlay.setOnAction(e -> {
            if (txtName.getText().isEmpty()) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Entry Error");
                error.setContentText("Name is a required field.");
                error.show();
                return;
            }
            for (int i = 0; i < txtName.getText().length(); i++) {
                if (Character.isDigit(txtName.getText().charAt(i)) == true) {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Entry Error");
                    error.setContentText("Name must not contain a digit");
                    error.show();
                    return;
                }
            }
            stage2.close();
            gameStage();
        });
        Scene scene2 = new Scene(root2, 1200, 720, Color.BLACK);
        stage2.setScene(scene2);
        stage2.show();
    }

    // This the last stage where the game will launch.
    Stage stage3;

    public void gameStage() {
        stage3 = new Stage();
        txtscore = new Text(1000, 50, "Score: " + score);
        txtscore.setFill(Color.WHITE);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        txtscore.setFont(font2);
        stage3.setTitle("Space Asteroids");
        rocket.add(imgviewShuttle);
        Space space = new Space();
        space.Create();
        imgviewShuttle.setLayoutX(570);
        imgviewShuttle.setLayoutY(450);
        root.getChildren().add(imgviewShuttle);
        root.getChildren().add(txtscore);
        Scene scene = new Scene(root, 1200, 720, Color.BLACK);
        stage3.setScene(scene);
        stage3.setResizable(false);
        stage3.show();
        // Using the Key event with booleans to get the game controls to work.
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = true;
                        break;
                    case DOWN:
                        goDown = true;
                        break;
                    case LEFT:
                        goLeft = true;
                        break;
                    case RIGHT:
                        goRight = true;
                        break;
                    case SPACE:
                        if (gameOver) {
                            return;
                        }
                        if (!shoot) {
                            Rectangle rect2 = new Rectangle();
                            rect2.setWidth(5.0f);
                            rect2.setHeight(10.0f);
                            rect2.setFill(Color.RED);
                            Node newWeapon = rect2;
                            newWeapon.relocate(imgviewShuttle.getLayoutX() + 45, imgviewShuttle.getLayoutY() - 5);
                            weapons.add(newWeapon);
                            root.getChildren().add(newWeapon);
                            shoot = true;
                            audioClip_Laser.play();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = false;
                        break;
                    case DOWN:
                        goDown = false;
                        break;
                    case LEFT:
                        goLeft = false;
                        break;
                    case RIGHT:
                        goRight = false;
                        break;
                    case SPACE:
                        shoot = false;
                        break;
                    default:
                        break;
                }
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            double delta = 4;

            @Override
            public void handle(long arg0) {
                double currX = imgviewShuttle.getLayoutX();
                double currY = imgviewShuttle.getLayoutY();
                if (imgviewShuttle.getLayoutX() < 1120) // Creating a invisble game wall border
                {
                    if (goUp)
                        currY -= delta;
                    if (goDown)
                        currY += delta;
                    if (goLeft)
                        currX -= delta;
                    if (goRight)
                        currX += delta;
                }
                if (imgviewShuttle.getLayoutX() >= 1120) {
                    if (goLeft)
                        currX -= delta;
                    if (goUp)
                        currY -= delta;
                    if (goDown)
                        currY += delta;
                }

                imgviewShuttle.relocate(currX, currY);
                Player shuttle = new Player();
                Fire fire = new Fire();
                fire.fire(dShoot);
                shuttle.collide();
                Asteroid asteroid = new Asteroid();
                asteroid.CreateAsteroid();
                asteroid.moveAsteroid();
                asteroid.collide();
            }
        };
        timer.start();
    }

    // Inner Classes start here
    public class Player {
        // This is if the shuttle collided with asteroid.
        public void collide() {
            for (int i = 0; i < rocket.size(); i++) {
                for (int j = 0; j < asteroid.size(); j++) {
                    if (rocket.get(i).getBoundsInParent().intersects(asteroid.get(j).getBoundsInParent())) {
                        gameOver = true;
                        Image imgExplosion = new Image(getClass().getResource("img/explosion.gif").toExternalForm());
                        AudioClip audioClip_Explosion = new AudioClip(
                                getClass().getResource("audio/Explosion2.WAV").toExternalForm());
                        ImageView imgviewExplosion = new ImageView(imgExplosion);
                        imgviewExplosion.relocate(rocket.get(i).getLayoutX(), rocket.get(i).getLayoutY());
                        root.getChildren().remove(asteroid.get(j));
                        PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
                        wait.setOnFinished((e) -> {
                            root.getChildren().remove(imgviewExplosion);
                        });
                        wait.play();
                        asteroid.remove(j);
                        root.getChildren().add(imgviewExplosion);
                        audioClip_Explosion.play();
                        root.getChildren().remove(rocket.get(i));
                        rocket.remove(i);
                        Text txtGameOver = new Text(500, 360, "Gameover!");
                        txtGameOver.setFill(Color.RED);
                        Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
                        txtGameOver.setFont(font3);
                        root.getChildren().add(txtGameOver);
                        Button btnQuit = new Button("Quit");
                        btnQuit.setScaleX(6);
                        btnQuit.setScaleY(4);
                        btnQuit.setTextFill(Color.YELLOW);
                        btnQuit.setTranslateX(1000);
                        btnQuit.setTranslateY(600);
                        btnQuit.setStyle("-fx-background-color: red;");
                        root.getChildren().add(btnQuit);
                        btnQuit.setOnAction(e -> Platform.exit());
                    }
                }
            }

            for (int i = 0; i < rocket.size(); i++) {
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (rocket.get(i).getBoundsInParent().intersects(bigAsteroid.get(j).getBoundsInParent())) {
                        gameOver = true;
                        Image imgExplosion = new Image(getClass().getResource("img/explosion.gif").toExternalForm());
                        AudioClip audioClip_Explosion = new AudioClip(
                                getClass().getResource("audio/Explosion2.WAV").toExternalForm());
                        ImageView imgviewExplosion = new ImageView(imgExplosion);
                        imgviewExplosion.relocate(rocket.get(i).getLayoutX(), rocket.get(i).getLayoutY());
                        root.getChildren().remove(bigAsteroid.get(j));
                        PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
                        wait.setOnFinished((e) -> {
                            root.getChildren().remove(imgviewExplosion);
                        });
                        wait.play();
                        bigAsteroid.remove(j);
                        root.getChildren().add(imgviewExplosion);
                        audioClip_Explosion.play();
                        root.getChildren().remove(rocket.get(i));
                        rocket.remove(i);
                        Text txtGameOver = new Text(500, 360, "Gameover!");
                        txtGameOver.setFill(Color.RED);
                        Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
                        txtGameOver.setFont(font3);
                        root.getChildren().add(txtGameOver);
                        Button btnQuit = new Button("Quit");
                        btnQuit.setScaleX(6);
                        btnQuit.setScaleY(4);
                        btnQuit.setTextFill(Color.YELLOW);
                        btnQuit.setTranslateX(1000);
                        btnQuit.setTranslateY(600);
                        btnQuit.setStyle("-fx-background-color: red;");
                        root.getChildren().add(btnQuit);
                        btnQuit.setOnAction(e -> Platform.exit());
                    }
                }
            }
        }
    }

    public class Asteroid {
        Image imgAsteroid = new Image(getClass().getResource("img/asteroid.png").toExternalForm());
        Image imgBigAsteroid = new Image(getClass().getResource("img/big_asteroid.png").toExternalForm());
        ImageView imgviewAsteroid = new ImageView(imgAsteroid);
        ImageView imgviewBigAsteroid = new ImageView(imgBigAsteroid);

        public void CreateAsteroid() {
            asteroidCounter++;
            asteroidCounter2++;
            // This is an algorithm that will spawn the asteroids, as your score gets bigger
            // more asteroids will spawn, to increase difficulty.
            if (score < 25) {
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter2 % modifier == 0) {
                    Node newBigAsteroid = new ImageView(imgBigAsteroid);
                    newBigAsteroid.relocate((int) (Math.random() * (H + newBigAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
                    bigAsteroid.add(newBigAsteroid);
                    root.getChildren().add(newBigAsteroid);
                }
            } else if (score >= 25 && score < 60) {
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter2 % modifier == 0) {
                    Node newBigAsteroid = new ImageView(imgBigAsteroid);
                    newBigAsteroid.relocate((int) (Math.random() * (H + newBigAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
                    bigAsteroid.add(newBigAsteroid);
                    root.getChildren().add(newBigAsteroid);
                }
            } else if (score >= 60 && score < 85) {
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter2 % modifier == 0) {
                    Node newBigAsteroid = new ImageView(imgBigAsteroid);
                    newBigAsteroid.relocate((int) (Math.random() * (H + newBigAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
                    bigAsteroid.add(newBigAsteroid);
                    root.getChildren().add(newBigAsteroid);
                }
            } else if (score >= 85) {
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter % modifier == 0) {
                    Node newAsteroid = new ImageView(imgAsteroid);
                    newAsteroid.relocate((int) (Math.random() * (W + newAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
                    asteroid.add(newAsteroid);
                    root.getChildren().add(newAsteroid);
                }
                if (asteroidCounter2 % modifier == 0) {
                    Node newBigAsteroid = new ImageView(imgBigAsteroid);
                    newBigAsteroid.relocate((int) (Math.random() * (H + newBigAsteroid.getBoundsInLocal().getWidth())),
                            (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
                    bigAsteroid.add(newBigAsteroid);
                    root.getChildren().add(newBigAsteroid);
                }
            }

        }

        // This methods cause the asteroids to move vertically downwards, the higher
        // your score is the faster the asteroids will move; to increase difficulty
        public void moveAsteroid() {
            if (score < 40) {
                for (int i = 0; i < asteroid.size(); i++) {
                    if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                        asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 7);
                    } else {
                        root.getChildren().remove(asteroid.get(i));
                        asteroid.remove(i);
                    }
                }
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                        bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(),
                                bigAsteroid.get(j).getLayoutY() + 6);
                    } else {
                        root.getChildren().remove(bigAsteroid.get(j));
                        bigAsteroid.remove(j);
                    }
                }
            } else if (score >= 40 && score < 70) {
                for (int i = 0; i < asteroid.size(); i++) {
                    if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                        asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 9);
                    } else {
                        root.getChildren().remove(asteroid.get(i));
                        asteroid.remove(i);
                    }
                }
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                        bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(),
                                bigAsteroid.get(j).getLayoutY() + 8);
                    } else {
                        root.getChildren().remove(bigAsteroid.get(j));
                        bigAsteroid.remove(j);
                    }
                }
            } else if (score >= 70 && score < 100) {
                for (int i = 0; i < asteroid.size(); i++) {
                    if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                        asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 11);
                    } else {
                        root.getChildren().remove(asteroid.get(i));
                        asteroid.remove(i);
                    }
                }
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                        bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(),
                                bigAsteroid.get(j).getLayoutY() + 10);
                    } else {
                        root.getChildren().remove(bigAsteroid.get(j));
                        bigAsteroid.remove(j);
                    }
                }
            } else if (score >= 100) {
                for (int i = 0; i < asteroid.size(); i++) {
                    if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                        asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 14);
                    } else {
                        root.getChildren().remove(asteroid.get(i));
                        asteroid.remove(i);
                    }
                }
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                        bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(),
                                bigAsteroid.get(j).getLayoutY() + 13);
                    } else {
                        root.getChildren().remove(bigAsteroid.get(j));
                        bigAsteroid.remove(j);
                    }
                }
            }
        }

        // This is if the laser beam collided with asteroid it will cause and explosion
        // and you will gain two points
        public void collide() {
            for (int i = 0; i < weapons.size(); i++) {
                for (int j = 0; j < asteroid.size(); j++) {
                    if (weapons.get(i).getBoundsInParent().intersects(asteroid.get(j).getBoundsInParent())) {
                        Image imgExplosion = new Image(getClass().getResource("img/explosion.gif").toExternalForm());
                        // add audio here for explosion
                        AudioClip audioClip_Explosion = new AudioClip(
                                getClass().getResource("audio/Explosion2.WAV").toExternalForm());
                        ImageView imgViewExplosion = new ImageView(imgExplosion);
                        imgViewExplosion.relocate(asteroid.get(j).getLayoutX(), asteroid.get(j).getLayoutY());
                        root.getChildren().remove(asteroid.get(j));
                        asteroid.remove(j);
                        root.getChildren().add(imgViewExplosion);
                        audioClip_Explosion.play();
                        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion
                                                                                           // doesn't infinitely loop.
                        wait.setOnFinished((e) -> {
                            root.getChildren().remove(imgViewExplosion);
                        });
                        wait.play();
                        root.getChildren().remove(weapons.get(i));
                        weapons.remove(i);
                        score += 2;
                        txtscore.setText("Score: " + score);
                    }
                }
            }
            for (int i = 0; i < weapons.size(); i++) {
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (weapons.get(i).getBoundsInParent().intersects(bigAsteroid.get(j).getBoundsInParent())) {
                        Image imgExplosion = new Image(getClass().getResource("img/bigexplosion.gif").toExternalForm());
                        AudioClip audioClip_Explosion = new AudioClip(
                                getClass().getResource("audio/Explosion2.WAV").toExternalForm());
                        ImageView imgviewExplosion = new ImageView(imgExplosion);
                        imgviewExplosion.relocate(bigAsteroid.get(j).getLayoutX(), bigAsteroid.get(j).getLayoutY());
                        root.getChildren().remove(bigAsteroid.get(j));
                        bigAsteroid.remove(j);
                        root.getChildren().add(imgviewExplosion);
                        audioClip_Explosion.play();
                        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion
                                                                                           // doesn't infinitely loop.
                        wait.setOnFinished((e) -> {
                            root.getChildren().remove(imgviewExplosion);
                        });
                        wait.play();
                        root.getChildren().remove(weapons.get(i));
                        weapons.remove(i);
                        score += 4;
                        txtscore.setText("Score: " + score);
                    }
                }
            }
        }
    }

    public class Fire {
        // This method causes the laser beam to move vertically upwards
        public void fire(int deltas) {
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getLayoutX() < W) {
                    weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() - deltas);
                } else
                    weapons.remove(i);
            }
        }
    }

    public class Space {
        // This classes will add the background image to the stage
        Image background = new Image(getClass().getResource("img/background.png").toExternalForm());
        ImageView imgbackground = new ImageView(background);

        public void Create() {
            root.getChildren().add(imgbackground);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
