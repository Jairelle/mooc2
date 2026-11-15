
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = {8, 2, 9, 1, 1};
        System.out.println(sum(numbers, 0, numbers.length, 0, 999));
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int start = fromWhere;
        if (start < 0) {
            start = 0;
        }

        int end = toWhere;
        if (end > array.length) {
            end = array.length;
        }

        int sum = 0;
        for (int i = start; i < end; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            }
        }

        return sum;
    }
}
