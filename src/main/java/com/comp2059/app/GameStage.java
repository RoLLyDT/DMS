package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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

import java.util.ArrayList;

public class GameStage {
    Stage stage;
    Space space;
    private MusicPlayer musicPlayer;


    boolean goUp, goDown, goLeft, goRight, shoot;
    ArrayList<Node> weapons = new ArrayList<>();
    Asteroids asteroids;
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
    int score = 0;
    GameStage gameStage;

    public GameStage(Stage stage, String space) {
        this.asteroids = new Asteroids();
        this.gameStage = this;
        this.stage = stage;
        this.space = new Space(space, gameStage);
        this.musicPlayer = new MusicPlayer();

        Image imgShuttle = new Image(HelloApplication.class.getResource("img/shuttle.png").toExternalForm());
        ImageView imgviewShuttle = new ImageView(imgShuttle);

        txtscore = new Text(1000, 50, "Score: " + score);
        txtscore.setFill(Color.WHITE);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        txtscore.setFont(font2);

        rocket.add(imgviewShuttle);
        this.space.Create();
        imgviewShuttle.setLayoutX(570);
        imgviewShuttle.setLayoutY(450);
        root.getChildren().add(imgviewShuttle);
        root.getChildren().add(txtscore);
        Scene scene = new Scene(root, 1200, 720, Color.BLACK);
        this.stage.setScene(scene);
        this.stage.setResizable(false);

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
                            musicPlayer.playLaser();
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
                Player shuttle = new Player(gameStage);
                Bullet fire = new Bullet(gameStage);
                fire.fire(dShoot);
                shuttle.collide();
                Asteroid asteroid = new Asteroid(gameStage);
                asteroid.CreateAsteroid();
                Velocity velocity=new Velocity(gameStage);
                velocity.moveAsteroid();
                Collisions collisions=new Collisions(gameStage);
                collisions.collide();
            }
        };
        timer.start();
    }

    public void increaseScore() {
        this.score++;
        txtscore.setText("Score: " + score);
    }

    public void show() {
        stage.show();
    }
}
