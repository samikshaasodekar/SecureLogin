package com.example.SecureLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setUndecorated(true); // Make undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use absolute positioning

        // Set Background Color
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(173, 216, 230)); // Light blue color
        backgroundPanel.setBounds(0, 0, 300, 200);
        backgroundPanel.setLayout(null); // Use absolute positioning
        add(backgroundPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK); // Black text for visibility
        titleLabel.setBounds(100, 10, 100, 30);
        backgroundPanel.add(titleLabel);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(230, 10, 60, 20);
        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        backgroundPanel.add(exitButton);

        // Form Fields and Labels
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK); // Black text for visibility
        emailLabel.setBounds(30, 60, 100, 25);
        backgroundPanel.add(emailLabel);

        emailField = new JTextField(15);
        emailField.setBounds(100, 60, 150, 25);
        backgroundPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK); // Black text for visibility
        passwordLabel.setBounds(30, 100, 100, 25);
        backgroundPanel.add(passwordLabel);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(100, 100, 150, 25);
        backgroundPanel.add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(100, 140, 90, 25);
        backgroundPanel.add(loginButton);

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(30, 170, 240, 25);
        backgroundPanel.add(messageLabel);
    }

    public String getEmail() { return emailField.getText(); }
    public String getPassword() { return new String(passwordField.getPassword()); }
    public void setMessage(String message) { messageLabel.setText(message); }
    public void addLoginListener(ActionListener listener) { loginButton.addActionListener(listener); }
}

