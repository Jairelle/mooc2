package borderpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        layout.setTop(new Label("NORTH"));
        layout.setRight(new Label("EAST"));
        layout.setBottom(new Label("SOUTH"));
        layout.setLeft(new Label("WEST"));
        layout.setCenter(new Label("CENTER"));

        BorderPane.setAlignment(layout.getTop(), Pos.CENTER);
        BorderPane.setAlignment(layout.getBottom(), Pos.CENTER);

        Scene view = new Scene(layout, 300, 180);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

}
