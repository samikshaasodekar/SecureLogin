package com.example.SecureLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegisterController {
    private UserModel model;
    private RegisterView registerView;
    private LoginView loginView;

    public RegisterController(UserModel model, RegisterView registerView, LoginView loginView) {
        this.model = model;
        this.registerView = registerView;
        this.loginView = loginView;

        registerView.addRegisterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        registerView.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerView.dispose();
                loginView.setVisible(true);
            }
        });
    }

    private void registerUser() {
        String username = registerView.getUsername();
        String email = registerView.getEmail();
        String password = registerView.getPassword();
        String phone = registerView.getPhone();

        // Clear previous message
        registerView.setMessage("");

        // Validate input fields
        if (!isValidEmail(email)) {
            registerView.setMessage("Invalid email format.");
            return;
        }

        if (!isValidPhone(phone)) {
            registerView.setMessage("Phone number must be exactly 10 digits.");
            return;
        }

        if (password.length() < 6) {
            registerView.setMessage("Password must be at least 6 characters.");
            return;
        }

        // Check if the email already exists in the model
        if (model.isEmailRegistered(email)) {
            registerView.setMessage("Email already registered. Please log in.");
        } else if (model.registerUser(username, email, password, phone)) {
            registerView.setMessage("Registration successful!");
            registerView.dispose();  
            loginView.setVisible(true);  
        } else {
            registerView.setMessage("Registration failed.");
        }
    }

    // Validate email format
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate phone number (must be 10 digits)
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
}

