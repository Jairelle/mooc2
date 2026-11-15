
public class MisplacingBox extends Box {

    public MisplacingBox() {
    }

    @Override
    public void add(Item item) {
        // the misplacing box loses everything that is added to it
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
