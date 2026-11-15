package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    private static final String JOKE = "What do you call a bear with no teeth?";
    private static final String ANSWER = "A gummy bear.";
    private static final String EXPLANATION = "A bear with no teeth cannot bite, "
            + "so it is as harmless as a gummy bear -- which is also a sweet.";

    @Override
    public void start(Stage window) {
        Label text = new Label(JOKE);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        jokeButton.setOnAction((event) -> text.setText(JOKE));
        answerButton.setOnAction((event) -> text.setText(ANSWER));
        explanationButton.setOnAction((event) -> text.setText(EXPLANATION));

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().addAll(jokeButton, answerButton, explanationButton);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setCenter(text);
        layout.setBottom(buttons);

        window.setScene(new Scene(layout, 450, 150));
        window.show();
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

}
