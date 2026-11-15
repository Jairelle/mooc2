package application;

import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1965, 2012, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Support (%)");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Relative support of the parties");

        try (Scanner reader = new Scanner(new File("partiesdata.tsv"))) {
            String[] years = reader.nextLine().split("\t");

            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split("\t");

                XYChart.Series party = new XYChart.Series();
                party.setName(parts[0]);

                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("-")) {
                        continue;
                    }

                    party.getData().add(new XYChart.Data(
                            Integer.valueOf(years[i]),
                            Double.valueOf(parts[i])));
                }

                chart.getData().add(party);
            }
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        window.setScene(new Scene(chart, 800, 600));
        window.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
