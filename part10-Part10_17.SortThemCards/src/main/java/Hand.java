
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream().forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand another) {
        return sumOfValues() - another.sumOfValues();
    }

    public int sumOfValues() {
        int sum = 0;
        for (Card card : this.cards) {
            sum += card.getValue();
        }

        return sum;
    }
}
