package com.example.SecureLogin;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class UserModel {
    private Connection connection;

    public UserModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password) {
        String query = "SELECT password FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                return BCrypt.checkpw(password, hashedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(String username, String email, String password, String phone) {
        String query = "INSERT INTO users (username, email, password, phone) VALUES (?, ?, ?, ?)";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);
            stmt.setString(4, phone);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isEmailRegistered(String email) {
        String query = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
