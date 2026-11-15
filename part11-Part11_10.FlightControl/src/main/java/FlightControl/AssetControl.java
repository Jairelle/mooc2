package FlightControl;

import java.util.Scanner;

public class AssetControl {

    private Logic logic;
    private Scanner scanner;

    public AssetControl(Logic logic, Scanner scanner) {
        this.logic = logic;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Airport Asset Control");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                addAirplane();
            } else if (command.equals("2")) {
                addFlight();
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(this.scanner.nextLine());

        this.logic.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the departure airport id: ");
        String departure = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String target = this.scanner.nextLine();

        this.logic.addFlight(id, departure, target);
    }
}
