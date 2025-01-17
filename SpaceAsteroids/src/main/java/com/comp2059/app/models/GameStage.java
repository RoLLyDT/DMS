package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
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


/**
 * The GameStage class creates the game stage.
 * 
 * @author TeamMinecraft
 */
public class GameStage {
    Stage stage;
    Space space;
    private MusicPlayer musicPlayer;

    boolean goUp, goDown, goLeft, goRight, shoot;
    ArrayList<Node> weapons = new ArrayList<>();
    public Asteroids asteroids;
    ArrayList<Node> rocket = new ArrayList<>();
    static final double L = 800, W = 1200, H = 720; // SIZES
    int dShoot = 10;
    public Group root = new Group();
    public int asteroidCounter = 0;
    public int asteroidCounter2 = 0;
    public int modifier = 150;
    double booster = 1;

    TextField txtName = new TextField();
    boolean gameOver = false;
    Text txtscore;
    Text txtlevel;
    public int score = 0;
    int level = 1;
    GameStage gameStage;
    private int points;
    /**
     * This constructor passed stage and space to GameStage class
     * 
     * @param stage The stage of the game
     * @param space The space of the game
     */
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


        txtlevel = new Text(80, 50, "Level: " + level);
        txtlevel.setFill(Color.WHITE);
        Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        txtlevel.setFont(font3);

        rocket.add(imgviewShuttle);
        this.space.Create();
        imgviewShuttle.setLayoutX(570);
        imgviewShuttle.setLayoutY(450);
        root.getChildren().add(imgviewShuttle);
        root.getChildren().add(txtscore);
        root.getChildren().add(txtlevel);
        Scene scene = new Scene(root, HelloApplication.W, HelloApplication.H, Color.BLACK);
        this.stage.setScene(scene);
        this.stage.setResizable(false);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            //method for bullet creation
            public void addBullet(int offsetX, int offsetY){
                Rectangle rect2 = new Rectangle();
                rect2.setWidth(5.0f);
                rect2.setHeight(10.0f);
                rect2.setFill(Color.RED);
                Node newWeapon = rect2;
                newWeapon.relocate(imgviewShuttle.getLayoutX() + offsetX, imgviewShuttle.getLayoutY() - offsetY);
                weapons.add(newWeapon);
                root.getChildren().add(newWeapon);
                shoot = true;
                musicPlayer.playLaser();
            }
            /**
             * This method handles the key pressed event
             * 
             * @param event The key pressed event
             * @return void
             * @throws Exception
             */
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
                            //based on the level change amount of bullets
                            if (level == 1)
                                addBullet(45, 5);
                            else if (level == 2) {
                                addBullet(35, 5);
                                addBullet(55, 5);
                            }
                            else if (level == 3){
                                addBullet(15, 5);
                                addBullet(75, 5);
                                addBullet(45, 5);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            /**
             * This method handles the key released event
             * 
             * @param event The key released event
             * @return void
             * @throws Exception
             */
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
            /**
             * This method handles the animation timer
             * 
             * @param arg0 The animation timer
             * @return void
             * @throws Exception
             */
            @Override
            public void handle(long arg0) {
                double currX = imgviewShuttle.getLayoutX();
                double currY = imgviewShuttle.getLayoutY();

                if (currX < scene.getWidth() - imgviewShuttle.getBoundsInParent().getWidth()) {
                    if (currY > 0)
                        if (goUp)
                            currY -= delta*booster;
                    if (currY < scene.getHeight() - imgviewShuttle.getBoundsInParent().getHeight())
                        if (goDown)
                            currY += delta*booster;
                    if (currX > -20)
                        if (goLeft)
                            currX -= delta*booster;
                    if (goRight)
                        currX += delta*booster;
                }
                if (currX >= scene.getWidth() - imgviewShuttle.getBoundsInParent().getWidth()) {
                    if (currY > 0)
                        if (goUp)
                            currY -= delta*booster;
                    if (currY < scene.getHeight() - imgviewShuttle.getBoundsInParent().getHeight())
                        if (goDown)
                            currY += delta*booster;
                    if (currX > -20)
                        if (goLeft)
                            currX -= delta*booster;
                }

                imgviewShuttle.relocate(currX, currY);
                Player shuttle = new Player(gameStage);
                Bullet fire = new Bullet(gameStage);
                fire.fire(dShoot);
                shuttle.collide();
                Asteroid asteroid = new Asteroid(gameStage);
                asteroid.CreateAsteroid();
                Velocity velocity = new Velocity(gameStage);
                velocity.moveAsteroid();
                Collisions collisions = new Collisions(gameStage);
                collisions.collide();
            }
        };
        timer.start();
    }
    /**
     * This method shows the stage
     */
    public void show() {
        stage.show();
    }
}
