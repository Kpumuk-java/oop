package mapper;

import exceptions.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserMapper {
    private final Connection connection;
    private String FOUND_USER_BY_ID = "SELECT id, name, age FROM users WHERE id = ?";
    private String UPDATE_USER_BY_ID = "UPDATE users SET name = ?, age = ? WHERE id = ?";
    private String SAVE_USER_BD = "INSERT INTO users (id, name, age) VALUES (?, ?, ?)";
    private String DELETE_USER_BD = "DELETE FROM users WHERE id = ?";

    public UserMapper(Connection c) {
        this.connection = c;
    }


    /*public User findById (String id) throws SQLException {
        if (!users.isEmpty()) {
            for (User u : users) {
                if (u.getId().equals(id)) {
                    return u;
                }
            }
        }

        PreparedStatement statement = this.connection.prepareStatement(FOUND_USER_BY_ID);
        statement.setString(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            while(resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                return user;
            }
        }

        throw new ResourceNotFoundException("User not found");
    }

    public HashSet<User> findAll () throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users");
        try (ResultSet resultSet = statement.executeQuery()) {
            users.clear();
            while(resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                users.add(user);
            }
            return users;
        }
    }

    private int updateUserFromDB (User user) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(UPDATE_USER_BY_ID);
        statement.setString(1, user.getName());
        statement.setInt(2, user.getAge());
        statement.setString(3, user.getId());
        return statement.executeUpdate();
    }


    public User saveOrUpdate (User user) throws SQLException {
        if (!users.isEmpty()) {
            Iterator<User> userIterator = users.iterator();
            User newUser;
            while (userIterator.hasNext()) {
                newUser = userIterator.next();
                if (newUser.equals(user)) {
                    updateUserFromDB(user);
                    userIterator.remove();
                    users.add(user);
                    return user;
                }
            }
        }
        if (updateUserFromDB(user) == 1) {
            users.add(user);
            return user;
        }
        saveUserDB(user);
        users.add(user);
        return user;
    }

    private void saveUserDB(User user) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(SAVE_USER_BD);
        statement.setString(1,user.getId());
        statement.setString(2, user.getName());
        statement.setInt(3, user.getAge());
        statement.execute();
    }

    public boolean delete (User user) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(DELETE_USER_BD);
        statement.setString(1, user.getId());
        if (statement.executeUpdate() == 1) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public HashSet<User> getUsers () {
        return users;
    }*/
}
