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

    // Rules stage, controls explanation stage and the stage where you input your
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
            checkShuttleAsteroid(asteroid, "img/explosion.gif", "audio/Explosion2.WAV");
            checkShuttleAsteroid(bigAsteroid, "img/big_explosion.gif", "audio/Explosion2.WAV");
        }

        // This is to check if the shuttle collided with asteroid.
        private void checkShuttleAsteroid(ArrayList<Node> asteroids, String explosionPath, String audioPath){
            for (int i = 0; i < rocket.size(); i++) {
                for (int j = 0; j < asteroids.size(); j++) {
                    if (rocket.get(i).getBoundsInParent().intersects(asteroids.get(j).getBoundsInParent())) {
                        contactShuttleAsteroid(i, j, explosionPath, audioPath, asteroids);
                    }
                }
            }
        }

        // Method to play the explosion sound and image.
        // Also to remove the asteroid and shuttle from the game.
        // Also to stop the game and display the game over screen.
        private void contactShuttleAsteroid(int i, int j, String explosionPath, String audioPath, ArrayList<Node> asteroids){
            gameOver = true;
            Image imgExplosion = new Image(getClass().getResource(explosionPath).toExternalForm());
            AudioClip audioClip_Explosion = new AudioClip(
                    getClass().getResource(audioPath).toExternalForm());
            ImageView imgviewExplosion = new ImageView(imgExplosion);
            imgviewExplosion.relocate(rocket.get(i).getLayoutX(), rocket.get(i).getLayoutY());
            root.getChildren().remove(asteroids.get(j));
            PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
            wait.setOnFinished((e) -> {
                root.getChildren().remove(imgviewExplosion);
            });
            wait.play();
            asteroids.remove(j);
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

    public class Asteroid {
        Image imgAsteroid = new Image(getClass().getResource("img/asteroid.png").toExternalForm());
        Image imgBigAsteroid = new Image(getClass().getResource("img/big_asteroid.png").toExternalForm());

        // This is to spawn the asteroids based on the current score.
        public void CreateAsteroid() {
            asteroidCounter++;
            asteroidCounter2++;
            // This is an algorithm that will spawn the asteroids, as your score gets bigger
            // more asteroids will spawn, to increase difficulty.
            if (score < 25) {
                spawnAsteroids(1, 1);
            } else if (score < 60) {
                spawnAsteroids(2, 1);
            } else if (score < 85) {
                spawnAsteroids(3, 1);
            } else {
                spawnAsteroids(4, 1);
            }
        }

        // This is the method that will spawn the asteroids.
        private void spawnAsteroids(int normalCnt, int bigCnt){
            if (asteroidCounter % modifier == 0){
                for (int i = 0; i < normalCnt; i++) {
                    createNewAsteroid(imgAsteroid);
                }
            }
            if (asteroidCounter2 % modifier == 0){
                for (int i = 0; i < bigCnt; i++) {
                    createNewAsteroid(imgBigAsteroid);
                }
            }
        }

        // This is the method that creates the asteroids.
        private void createNewAsteroid(Image img){
            double x = W;
            if (img == imgBigAsteroid)
                x = H;
            Node newAsteroid = new ImageView(img);
            newAsteroid.relocate((int) (Math.random() * (x + newAsteroid.getBoundsInLocal().getWidth())),
                    (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
            if (img == imgBigAsteroid)
                bigAsteroid.add(newAsteroid);
            else
                asteroid.add(newAsteroid);
            root.getChildren().add(newAsteroid);
        }

        // This method cause the asteroids to move vertically downwards, the higher
        // your score is the faster the asteroids will move; to increase difficulty
        public void moveAsteroid() {
            if (score < 40) {
                speedAsteroids(asteroid, 7);
                speedAsteroids(bigAsteroid, 6);
            } else if (score < 70) {
                speedAsteroids(asteroid, 9);
                speedAsteroids(bigAsteroid, 8);
            } else if (score < 100) {
                speedAsteroids(asteroid, 11);
                speedAsteroids(bigAsteroid, 10);
            } else {
                speedAsteroids(asteroid, 14);
                speedAsteroids(bigAsteroid, 13);
            }
        }

        //Simplified process of increasing velocity of asteroids
        private void speedAsteroids(ArrayList<Node> asteroids, int buff){
            for (int i = 0; i < asteroids.size(); i++) {
                if (asteroids.get(i).getLayoutX() > -asteroids.get(i).getBoundsInLocal().getWidth()) {
                    asteroids.get(i).relocate(asteroids.get(i).getLayoutX(), asteroids.get(i).getLayoutY() + buff);
                } else {
                    root.getChildren().remove(asteroids.get(i));
                    asteroids.remove(i);
                }
            }
        }

        // This is the method that runs the process of checking for collisions between
        // the rocket and the asteroids. With making sounds/visual effects/score update.
        public void collide() {
            checkWeaponsAsteroid(asteroid, 2, "img/explosion.gif", "audio/Explosion2.WAV");
            checkWeaponsAsteroid(bigAsteroid, 4, "img/bigexplosion.gif", "audio/Explosion2.WAV");
        }

        // This is the method that will loop through the asteroids and check if the
        // laser beam collided with the asteroid.
        public void checkWeaponsAsteroid(ArrayList<Node> asteroids,int points, String explosionPath, String audioPath){
            for (int i = 0; i < weapons.size(); i++) {
                for (int j = 0; j < asteroids.size(); j++) {
                    if (weapons.get(i).getBoundsInParent().intersects(asteroids.get(j).getBoundsInParent())) {
                        contactWeaponAsteroid(i, j, points, explosionPath, audioPath, asteroids);
                    }
                }
            }
        }

        // This is the method that will cause the explosion effect and add the points to the score.
        // Requires the index of the weapon and asteroid, the points to add, the path of the explosion
        // effect, the path of the audio clip, and the asteroid array list.
        private void contactWeaponAsteroid(int i, int j, int points, String explosionPath, String audioPath, ArrayList<Node> asteroids){
            Image imgExplosion = new Image(getClass().getResource(explosionPath).toExternalForm());
            // add audio here for explosion
            AudioClip audioClip_Explosion = new AudioClip(
                    getClass().getResource(audioPath).toExternalForm());
            ImageView imgViewExplosion = new ImageView(imgExplosion);
            imgViewExplosion.relocate(asteroids.get(j).getLayoutX(), asteroids.get(j).getLayoutY());
            root.getChildren().remove(asteroids.get(j));
            asteroids.remove(j);
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
            score += points;
            txtscore.setText("Score: " + score);
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
