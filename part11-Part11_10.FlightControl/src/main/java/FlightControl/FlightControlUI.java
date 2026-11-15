package FlightControl;

import java.util.Scanner;

public class FlightControlUI {

    private Logic logic;
    private Scanner scanner;

    public FlightControlUI(Logic logic, Scanner scanner) {
        this.logic = logic;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Flight Control");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                for (Airplane airplane : this.logic.getAirplanes()) {
                    System.out.println(airplane);
                }
            } else if (command.equals("2")) {
                for (Flight flight : this.logic.getFlights()) {
                    System.out.println(flight);
                }
            } else if (command.equals("3")) {
                System.out.print("Give the airplane id: ");
                String id = this.scanner.nextLine();
                Airplane airplane = this.logic.getAirplane(id);
                if (airplane != null) {
                    System.out.println(airplane);
                }
            }
        }
    }
}
