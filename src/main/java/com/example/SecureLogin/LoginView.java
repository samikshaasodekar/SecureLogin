package com.example.SecureLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginView() {
        setTitle("Login");
        setSize(400, 400);
        setUndecorated(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        // Set Background Color
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(173, 216, 230)); 
        backgroundPanel.setBounds(0, 0, 400, 400);
        backgroundPanel.setLayout(null); 
        add(backgroundPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
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
        addLabelAndField(backgroundPanel, "Username:", 50, 80, usernameField = new JTextField());
        addLabelAndField(backgroundPanel, "Password:", 50, 120, passwordField = new JPasswordField());

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(50, 160, 300, 25);
        backgroundPanel.add(messageLabel);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 100, 30);
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
    public String getPassword() { return new String(passwordField.getPassword()); }
    public void setMessage(String message) { messageLabel.setText(message); }
    public void addLoginListener(ActionListener listener) { loginButton.addActionListener(listener); }
}


