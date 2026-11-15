
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card first, Card second) {
        if (first.getSuit() != second.getSuit()) {
            return first.getSuit().ordinal() - second.getSuit().ordinal();
        }

        return first.getValue() - second.getValue();
    }
}
