package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaService {
    private final Connection connection;
    private String FOUND_FILM_OVERLAY = "SELECT id, name, age FROM users WHERE id = ?";
    private String FOUND_FILM = "SELECT id, name, time FROM films";

    public CinemaService(Connection connection) {
        this.connection = connection;
    }

    public void found () throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(FOUND_FILM);
        try (ResultSet resultSet = statement.executeQuery()) {
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getTimestamp(3));
            }
        }
    }
}
