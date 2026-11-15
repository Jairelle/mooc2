package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext painter = canvas.getGraphicsContext2D();

        // the background
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, 640, 480);

        // the eyes
        painter.setFill(Color.BLACK);
        painter.fillRect(200, 150, 40, 80);
        painter.fillRect(400, 150, 40, 80);

        // the mouth
        painter.fillRect(220, 330, 200, 40);
        painter.fillRect(180, 290, 40, 40);
        painter.fillRect(420, 290, 40, 40);

        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);

        window.setScene(new Scene(layout));
        window.setTitle("Smiley");
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
