package FlightControl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        new AssetControl(logic, scanner).start();

        System.out.println();

        new FlightControlUI(logic, scanner).start();
    }
}
