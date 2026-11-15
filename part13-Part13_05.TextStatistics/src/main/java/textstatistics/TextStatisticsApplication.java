package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        TextArea textArea = new TextArea();

        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");

        HBox statistics = new HBox();
        statistics.setSpacing(10);
        statistics.getChildren().addAll(letters, words, longestWord);

        BorderPane layout = new BorderPane();
        layout.setCenter(textArea);
        layout.setBottom(statistics);

        Scene view = new Scene(layout, 400, 300);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
