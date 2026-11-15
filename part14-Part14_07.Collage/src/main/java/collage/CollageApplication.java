package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage window) {
        Image sourceImage = new Image("file:monalisa.png");

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        PixelReader reader = sourceImage.getPixelReader();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();

        // every other pixel of the source image is copied into each of the four
        // corners of the target image, and the colors are inverted on the way
        for (int x = 0; x < width / 2; x++) {
            for (int y = 0; y < height / 2; y++) {
                Color color = reader.getColor(x * 2, y * 2);
                Color inverted = Color.color(
                        1.0 - color.getRed(),
                        1.0 - color.getGreen(),
                        1.0 - color.getBlue(),
                        color.getOpacity());

                writer.setColor(x, y, inverted);
                writer.setColor(x + width / 2, y, inverted);
                writer.setColor(x, y + height / 2, inverted);
                writer.setColor(x + width / 2, y + height / 2, inverted);
            }
        }

        Pane layout = new Pane();
        layout.getChildren().add(new ImageView(targetImage));

        window.setScene(new Scene(layout, width, height));
        window.show();
    }

    public static void main(String[] args) {
        launch(CollageApplication.class);
    }

}
