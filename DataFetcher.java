package org.example.project1;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataFetcher {

    public static void fetchData(BarChart<String, Number> barChart, PieChart pieChart) {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root"; // Specify your database name
        String user = "root";
        String password = "Jo11el00@";

        String query = "SELECT country, population FROM country_population";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Population");

            while (rs.next()) {
                String country = rs.getString("country");
                int population = rs.getInt("population");

                // Add data to Bar Chart
                series.getData().add(new XYChart.Data<>(country, population));

                // Add data to Pie Chart
                pieChart.getData().add(new PieChart.Data(country, population));
            }

            barChart.getData().add(series);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}