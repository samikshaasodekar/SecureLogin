package com.example.SecureLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginController {
    private UserModel model;
    private LoginView view;

    public LoginController(UserModel model, LoginView view) {
        this.model = model;
        this.view = view;

        view.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {
        String email = view.getEmail();
        String password = view.getPassword();

        if (!isValidEmail(email)) {
            view.setMessage("Invalid email format.");
        } else if (password.isEmpty()) {
            view.setMessage("Password cannot be empty.");
        } else if (model.login(email, password)) {
            view.setMessage("Login successful!");
        } else {
            view.setMessage("Invalid credentials.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }
}
