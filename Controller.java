package org.example.project1;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Controller {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private PieChart pieChart;

    @FXML
    public void initialize() {
        loadData();
    }

    private void loadData() {
        // Hardcoded data for testing
        String[] countries = {"USA", "China", "India", "Germany", "UK"};
        int[] populations = {331002651, 1439323776, 1380004385, 83783942, 67886011};

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Population");

        for (int i = 0; i < countries.length; i++) {
            String country = countries[i];
            int population = populations[i];

            // Add data to Bar Chart
            series.getData().add(new XYChart.Data<>(country, population));

            // Add data to Pie Chart
            pieChart.getData().add(new PieChart.Data(country, population));
        }

        barChart.getData().add(series);
    }
}