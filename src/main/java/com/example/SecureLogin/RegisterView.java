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
        setUndecorated(true); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        
        // Set Background Color
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(173, 216, 230)); 
        backgroundPanel.setBounds(0, 0, 400, 400);
        backgroundPanel.setLayout(null); 
        add(backgroundPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Register", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(100, 10, 200, 30);
        backgroundPanel.add(titleLabel);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(350, 11, 60, 30);
        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        backgroundPanel.add(exitButton);

        // Form Fields
        addLabelAndField(backgroundPanel, "Username:", 50, 60, usernameField = new JTextField());
        addLabelAndField(backgroundPanel, "Email:", 50, 100, emailField = new JTextField());
        addLabelAndField(backgroundPanel, "Password:", 50, 140, passwordField = new JPasswordField());
        addLabelAndField(backgroundPanel, "Phone:", 50, 180, phoneField = new JTextField());

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(50, 220, 300, 25);
        backgroundPanel.add(messageLabel);

        // Register and Login Buttons
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 260, 90, 30);
        backgroundPanel.add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(210, 260, 90, 30);
        backgroundPanel.add(loginButton);
    }

    private void addLabelAndField(JPanel panel, String labelText, int x, int y, JTextField field) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 100, 25);
        panel.add(label);
        
        field.setBounds(x + 100, y, 200, 25);
        panel.add(field);
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
