package asteroids;

import java.util.Random;
import javafx.scene.shape.Polygon;

public class Asteroid extends Character {

    private static final Random RANDOM = new Random();

    private double rotationalMovement;

    public Asteroid(int x, int y) {
        super(createPolygon(), x, y);

        getCharacter().setRotate(RANDOM.nextInt(360));

        int accelerationAmount = 1 + RANDOM.nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        }

        this.rotationalMovement = 0.5 - RANDOM.nextDouble();
    }

    private static Polygon createPolygon() {
        double size = 10 + RANDOM.nextInt(10);

        Polygon polygon = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5;
            polygon.getPoints().addAll(
                    size * Math.cos(angle) + (RANDOM.nextInt(5) - 2),
                    size * Math.sin(angle) + (RANDOM.nextInt(5) - 2));
        }

        return polygon;
    }

    @Override
    public void move() {
        super.move();
        getCharacter().setRotate(getCharacter().getRotate() + this.rotationalMovement);
    }
}
