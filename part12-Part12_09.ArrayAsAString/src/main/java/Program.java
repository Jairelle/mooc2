
public class Program {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 5, 0},
            {3, 0, 7}
        };

        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                result.append(array[row][column]);
            }

            result.append("\n");
        }

        return result.toString();
    }
}
