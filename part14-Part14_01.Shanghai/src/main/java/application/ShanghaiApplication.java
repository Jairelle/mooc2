package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2017, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("The ranking of the University of Helsinki");
        chart.setLegendVisible(false);

        XYChart.Series ranking = new XYChart.Series();
        ranking.getData().add(new XYChart.Data(2007, 73));
        ranking.getData().add(new XYChart.Data(2011, 74));
        ranking.getData().add(new XYChart.Data(2016, 56));

        chart.getData().add(ranking);

        window.setScene(new Scene(chart, 640, 480));
        window.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
