
public class Hideout<T> {

    private T hidden;

    public Hideout() {
        this.hidden = null;
    }

    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }

    public T takeFromHideout() {
        T taken = this.hidden;
        this.hidden = null;

        return taken;
    }

    public boolean isInHideout() {
        return this.hidden != null;
    }
}
