package com.FirstJava;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //interaction with MySQL database

    public static Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/test";
        final String username = "root";
        final String password = "1234";

        return DriverManager.getConnection(url, username, password);
    }

    public List<String> getDepartureCities() {
        List<String> cities = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT DISTINCT departure FROM routes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                cities.add(resultSet.getString("departure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<String> getDestinationCities(String targetDeparture) {
        List<String> destinations = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT DISTINCT destination FROM routes WHERE departure = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, targetDeparture);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                destinations.add(resultSet.getString("destination"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinations;
    }

    public List<Flight> getAvailableFlights(String fromCity, String toCity, LocalDate departureDate) {
        List<Flight> flights = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM test.routes " +
                    "WHERE departure = ? " +
                    "  AND destination = ? " +
                    "  AND flight_days = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fromCity);
            preparedStatement.setString(2, toCity);
            preparedStatement.setInt(3, Validation.sortFlightDays(departureDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flights.add(new Flight(
                        resultSet.getString("airline"),
                        resultSet.getString("departure"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_times"),
                        resultSet.getString("arrivalTime"),
                        resultSet.getInt("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public void uploadUserToDatabase(User user) {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO users (name) VALUES (?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, user.getPassengerName());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}







