package com.example.SecureLogin;

import javax.swing.*;
import java.awt.*;

public class SplashScreenView extends JFrame {
    private JProgressBar progressBar;

    public SplashScreenView() {
        setTitle("Splash Screen");
        setSize(400, 400);
        setUndecorated(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        // Load and scale the background image to fit the frame
        ImageIcon originalImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/sl.jpg"));
        Image scaledImage = originalImageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, 400, 400);
        add(backgroundLabel);

        // Progress Bar
        progressBar = new JProgressBar();
        progressBar.setBounds(50, 300, 300, 20);
        progressBar.setForeground(new Color(0, 128, 128));
        backgroundLabel.add(progressBar);

        // Set the backgroundLabel layout to null to ensure it holds absolute positions
        backgroundLabel.setLayout(null);
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }

    public void displaySplashScreen() {
        setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(30); 
                updateProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setVisible(false);
    }
}
