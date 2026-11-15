
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int howMany = Integer.valueOf(scanner.nextLine());

        Random random = new Random();
        int printed = 0;
        while (printed < howMany) {
            System.out.println(random.nextInt(11));
            printed++;
        }
    }
}
