
import java.util.ArrayList;

public class Herd implements Movable {

    private ArrayList<Movable> movables;

    public Herd() {
        this.movables = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.movables.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.movables) {
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String text = "";
        for (Movable movable : this.movables) {
            text += movable.toString() + "\n";
        }

        return text;
    }
}
