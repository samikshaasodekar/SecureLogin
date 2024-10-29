package com.example.SecureLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel messageLabel;

    public RegisterView() {
        setTitle("Registration");
        setSize(400, 400);
        setUndecorated(true); // Make undecorated
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use absolute positioning

        // Set Background Color
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(173, 216, 230)); // Light blue color
        backgroundPanel.setBounds(0, 0, 400, 400);
        backgroundPanel.setLayout(null); // Use absolute positioning
        add(backgroundPanel);

        // Title Panel with "Registration" Heading and Exit Button
        JLabel titleLabel = new JLabel("Registration", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK); // Black text for visibility
        titleLabel.setBounds(100, 10, 200, 30);
        backgroundPanel.add(titleLabel);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(330, 10, 60, 20);
        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        backgroundPanel.add(exitButton);

        // Form Fields and Labels
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.BLACK); // Black text for visibility
        usernameLabel.setBounds(50, 60, 100, 25);
        backgroundPanel.add(usernameLabel);

        usernameField = new JTextField(15);
        usernameField.setBounds(150, 60, 200, 25);
        backgroundPanel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK); // Black text for visibility
        emailLabel.setBounds(50, 100, 100, 25);
        backgroundPanel.add(emailLabel);

        emailField = new JTextField(15);
        emailField.setBounds(150, 100, 200, 25);
        backgroundPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK); // Black text for visibility
        passwordLabel.setBounds(50, 140, 100, 25);
        backgroundPanel.add(passwordLabel);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(150, 140, 200, 25);
        backgroundPanel.add(passwordField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.BLACK); // Black text for visibility
        phoneLabel.setBounds(50, 180, 100, 25);
        backgroundPanel.add(phoneLabel);

        phoneField = new JTextField(15);
        phoneField.setBounds(150, 180, 200, 25);
        backgroundPanel.add(phoneField);

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(50, 220, 300, 25);
        backgroundPanel.add(messageLabel);

        // Register and Login Buttons
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 260, 90, 25);
        backgroundPanel.add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(210, 260, 90, 25);
        backgroundPanel.add(loginButton);
    }

    // Getters for input fields
    public String getUsername() { return usernameField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getPassword() { return new String(passwordField.getPassword()); }
    public String getPhone() { return phoneField.getText(); }
    public void setMessage(String message) { messageLabel.setText(message); }
    public void addRegisterListener(ActionListener listener) { registerButton.addActionListener(listener); }
    public void addLoginListener(ActionListener listener) { loginButton.addActionListener(listener); }
}
