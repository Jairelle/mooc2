package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {

    private Polygon character;
    private Point2D movement;
    private boolean alive;

    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.movement = new Point2D(0, 0);
        this.alive = true;
    }

    public Polygon getCharacter() {
        return this.character;
    }

    public Point2D getMovement() {
        return this.movement;
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate())) * 0.05;
        double changeY = Math.sin(Math.toRadians(this.character.getRotate())) * 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }

    public void move() {
        this.character.setTranslateX(wrap(this.character.getTranslateX() + this.movement.getX(), AsteroidsApplication.WIDTH));
        this.character.setTranslateY(wrap(this.character.getTranslateY() + this.movement.getY(), AsteroidsApplication.HEIGHT));
    }

    private double wrap(double value, double max) {
        if (value < 0) {
            return value + max;
        }

        if (value > max) {
            return value % max;
        }

        return value;
    }

    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
