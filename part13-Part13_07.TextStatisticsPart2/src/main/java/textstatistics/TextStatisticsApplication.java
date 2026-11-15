package textstatistics;

import java.util.Arrays;
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

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            letters.setText("Letters: " + newValue.length());

            if (newValue.isEmpty()) {
                words.setText("Words: 0");
                longestWord.setText("The longest word is: ");
                return;
            }

            String[] parts = newValue.split(" ");
            words.setText("Words: " + parts.length);

            String longest = Arrays.stream(parts)
                    .sorted((first, second) -> second.length() - first.length())
                    .findFirst()
                    .get();

            longestWord.setText("The longest word is: " + longest);
        });

        HBox statistics = new HBox();
        statistics.setSpacing(10);
        statistics.getChildren().addAll(letters, words, longestWord);

        BorderPane layout = new BorderPane();
        layout.setCenter(textArea);
        layout.setBottom(statistics);

        Scene view = new Scene(layout, 500, 300);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
