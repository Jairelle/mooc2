
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

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

        String command = scanner.nextLine();

        double sum = 0;
        int count = 0;

        for (int number : numbers) {
            if (command.equals("n") && number < 0) {
                sum += number;
                count++;
            } else if (command.equals("p") && number > 0) {
                sum += number;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(sum / count);
        }
    }
}
