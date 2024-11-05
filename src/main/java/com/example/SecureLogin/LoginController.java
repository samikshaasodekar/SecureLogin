package com.example.SecureLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

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
            sendVerificationEmail(email);
        } else {
            view.setMessage("Invalid credentials.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    public void sendVerificationEmail(String email) {
        final String senderEmail = "samikshaasodekar20@gmail.com";
        final String senderPassword = "";

        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");

        Session session = Session.getInstance(p, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Login Successful");
            message.setText("You have logged in successfully.");

            Transport.send(message);
            view.setMessage("Verification email sent.");

        } catch (MessagingException e) {
            e.printStackTrace();
            view.setMessage("Failed to send verification email.");
        }
    }
}