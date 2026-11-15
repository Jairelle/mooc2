package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private List<String[]> wordPairs;
    private int current;

    @Override
    public void init() throws Exception {
        this.wordPairs = new ArrayList<>();
        this.current = 0;

        String file = getParameters().getNamed().get("file");
        if (file == null) {
            file = "words.txt";
        }

        try (Scanner fileReader = new Scanner(new File(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }

                this.wordPairs.add(new String[]{parts[0].trim(), parts[1].trim()});
            }
        } catch (Exception e) {
            System.out.println("Error reading the file " + file + ": " + e.getMessage());
        }

        Collections.shuffle(this.wordPairs);
    }

    @Override
    public void start(Stage window) {
        Label wordToTranslate = new Label();
        Label feedback = new Label("");
        TextField answerField = new TextField();
        Button checkButton = new Button("Check");

        if (this.wordPairs.isEmpty()) {
            wordToTranslate.setText("No words to practise.");
            checkButton.setDisable(true);
        } else {
            wordToTranslate.setText(this.wordPairs.get(this.current)[0]);
        }

        checkButton.setOnAction((event) -> {
            if (this.wordPairs.isEmpty()) {
                return;
            }

            String correct = this.wordPairs.get(this.current)[1];
            if (answerField.getText().trim().equalsIgnoreCase(correct)) {
                feedback.setText("Correct!");
                this.current = (this.current + 1) % this.wordPairs.size();
                wordToTranslate.setText(this.wordPairs.get(this.current)[0]);
                answerField.clear();
            } else {
                feedback.setText("Incorrect! The correct answer was: " + correct);
            }
        });

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(wordToTranslate, answerField, checkButton, feedback);

        window.setScene(new Scene(layout, 350, 200));
        window.setTitle("Vocabulary practice");
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class, args);
    }

}
