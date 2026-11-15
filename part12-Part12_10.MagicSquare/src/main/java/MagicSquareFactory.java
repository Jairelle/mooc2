
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // The Siamese method: start from the middle of the first row and keep
        // moving up and to the right, wrapping around the edges. When the next
        // square is already taken, move one step down instead.
        int x = size / 2;
        int y = 0;

        for (int value = 1; value <= size * size; value++) {
            square.placeValue(x, y, value);

            int nextX = (x + 1) % size;
            int nextY = (y - 1 + size) % size;

            if (square.readValue(nextX, nextY) != 0) {
                y = (y + 1) % size;
            } else {
                x = nextX;
                y = nextY;
            }
        }

        return square;
    }

}
