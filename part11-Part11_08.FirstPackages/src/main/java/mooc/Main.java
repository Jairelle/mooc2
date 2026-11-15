package mooc;

import mooc.logic.ApplicationLogic;
import mooc.ui.TextInterface;
import mooc.ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new TextInterface();
        ApplicationLogic logic = new ApplicationLogic(ui);
        logic.execute(3);
    }
}
