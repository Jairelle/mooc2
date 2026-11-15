package title;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) {
        Parameters parameters = getParameters();

        String organization = parameters.getNamed().get("organization");
        String course = parameters.getNamed().get("course");

        window.setTitle(organization + ": " + course);

        FlowPane layout = new FlowPane();
        layout.getChildren().add(new Label("The title comes from the launch parameters."));

        window.setScene(new Scene(layout, 300, 100));
        window.show();
    }

}
