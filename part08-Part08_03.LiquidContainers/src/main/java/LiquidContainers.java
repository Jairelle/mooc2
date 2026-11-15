import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;

        System.out.println("First: " + first + "/100");
        System.out.println("Second: " + second + "/100");

        while (true) {
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (amount > 0) {
                if (command.equals("add")) {
                    first = Math.min(100, first + amount);

                } else if (command.equals("move")) {
                    // Cannot move more than what first currently holds
                    int toMove = Math.min(first, amount);
                    first -= toMove;
                    second = Math.min(100, second + toMove);

                } else if (command.equals("remove")) {
                    // Cannot go below 0
                    second = Math.max(0, second - amount);
                }
            }

            // Print once per loop iteration
            System.out.println();
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
        }

        scan.close();
    }
}