package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage window) {
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);

        Slider interestRateSlider = new Slider(0, 10, 0);
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setShowTickMarks(true);

        Label savingsValue = new Label("" + savingsSlider.getValue());
        Label interestRateValue = new Label("" + interestRateSlider.getValue());

        BorderPane savingsPane = new BorderPane();
        savingsPane.setLeft(new Label("Monthly savings"));
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsValue);

        BorderPane interestRatePane = new BorderPane();
        interestRatePane.setLeft(new Label("Yearly interest rate"));
        interestRatePane.setCenter(interestRateSlider);
        interestRatePane.setRight(interestRateValue);

        VBox sliders = new VBox();
        sliders.getChildren().addAll(savingsPane, interestRatePane);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setLegendVisible(false);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(sliders);
        layout.setCenter(chart);

        savingsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            savingsValue.setText("" + newValue.doubleValue());
            drawChart(chart, savingsSlider.getValue(), interestRateSlider.getValue());
        });

        interestRateSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            interestRateValue.setText("" + newValue.doubleValue());
            drawChart(chart, savingsSlider.getValue(), interestRateSlider.getValue());
        });

        drawChart(chart, savingsSlider.getValue(), interestRateSlider.getValue());

        window.setScene(new Scene(layout, 640, 480));
        window.show();
    }

    private void drawChart(LineChart<Number, Number> chart, double monthlySavings, double interestRate) {
        chart.getData().clear();

        XYChart.Series savings = new XYChart.Series();

        double total = 0;
        savings.getData().add(new XYChart.Data(0, total));

        for (int year = 1; year <= 30; year++) {
            total = (total + monthlySavings * 12) * (1 + interestRate / 100.0);
            savings.getData().add(new XYChart.Data(year, total));
        }

        chart.getData().add(savings);
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
