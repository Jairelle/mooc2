package mooc.logic;

import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int times) {
        int executed = 0;
        while (executed < times) {
            System.out.println("Executing the application logic!");
            ui.update();
            executed++;
        }
    }
}
