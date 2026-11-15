package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    @Override
    public void start(Stage window) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        Random random = new Random();

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);

        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            asteroids.add(new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT)));
        }

        List<Projectile> projectiles = new ArrayList<>();

        Text pointsText = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();

        pane.getChildren().add(pointsText);
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        Scene view = new Scene(pane);
        view.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), Boolean.TRUE));
        view.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), Boolean.FALSE));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    projectiles.add(projectile);
                    pane.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                // a projectile destroys an asteroid and gives points
                for (Projectile projectile : projectiles) {
                    for (Asteroid asteroid : asteroids) {
                        if (projectile.isAlive() && asteroid.isAlive() && projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                            pointsText.setText("Points: " + points.addAndGet(1000));
                        }
                    }
                }

                // the game ends when the ship hits an asteroid
                for (Asteroid asteroid : asteroids) {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                }

                removeDead(projectiles, pane);
                removeDead(asteroids, pane);

                // new asteroids appear every now and then
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT));
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();

        window.setTitle("Asteroids!");
        window.setScene(view);
        window.show();
    }

    private static <T extends Character> void removeDead(List<T> characters, Pane pane) {
        Iterator<T> iterator = characters.iterator();
        while (iterator.hasNext()) {
            T character = iterator.next();
            if (!character.isAlive()) {
                pane.getChildren().remove(character.getCharacter());
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
}
