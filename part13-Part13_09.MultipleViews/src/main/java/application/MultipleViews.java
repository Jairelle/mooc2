package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) {
        // first view: BorderPane with a label at the top and a button in the center
        Button firstButton = new Button("To the second view");
        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(new Label("First view"));
        firstLayout.setCenter(firstButton);
        Scene firstView = new Scene(firstLayout, 300, 200);

        // second view: VBox with a button and a label
        Button secondButton = new Button("To the third view");
        VBox secondLayout = new VBox();
        secondLayout.setSpacing(10);
        secondLayout.getChildren().add(secondButton);
        secondLayout.getChildren().add(new Label("Second view"));
        Scene secondView = new Scene(secondLayout, 300, 200);

        // third view: GridPane with a label and a button
        Button thirdButton = new Button("Back to the first view");
        GridPane thirdLayout = new GridPane();
        thirdLayout.add(new Label("Third view"), 0, 0);
        thirdLayout.add(thirdButton, 0, 1);
        Scene thirdView = new Scene(thirdLayout, 300, 200);

        firstButton.setOnAction((event) -> window.setScene(secondView));
        secondButton.setOnAction((event) -> window.setScene(thirdView));
        thirdButton.setOnAction((event) -> window.setScene(firstView));

        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
