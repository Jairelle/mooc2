import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();

            // 1. Check for quit or blank line before splitting/indexing
            if (input.equals("quit") || input.isEmpty()) {
                break;
            }

            String[] parts = input.split(" ");
            
            // Safety guard: skip if there's no amount argument provided
            if (parts.length < 2) {
                continue;
            }

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                first.add(amount);

            } else if (command.equals("move")) {
                int amountToMove = Math.min(amount, first.contains());
                first.remove(amountToMove);
                second.add(amountToMove);

            } else if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }
}