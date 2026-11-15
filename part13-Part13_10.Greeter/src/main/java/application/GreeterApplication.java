package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {
        TextField nameField = new TextField();
        Button startButton = new Button("Start");

        VBox startLayout = new VBox();
        startLayout.setSpacing(10);
        startLayout.setPadding(new Insets(10, 10, 10, 10));
        startLayout.getChildren().addAll(nameField, startButton);

        Scene startView = new Scene(startLayout, 300, 150);

        Label greeting = new Label();
        StackPane greetingLayout = new StackPane();
        greetingLayout.setAlignment(Pos.CENTER);
        greetingLayout.getChildren().add(greeting);

        Scene greetingView = new Scene(greetingLayout, 300, 150);

        startButton.setOnAction((event) -> {
            greeting.setText("Welcome " + nameField.getText() + "!");
            window.setScene(greetingView);
        });

        window.setScene(startView);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

}
