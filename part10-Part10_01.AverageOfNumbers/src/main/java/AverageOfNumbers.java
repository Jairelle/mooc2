
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            numbers.add(Integer.valueOf(input));
        }

        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum / numbers.size());
    }
}
