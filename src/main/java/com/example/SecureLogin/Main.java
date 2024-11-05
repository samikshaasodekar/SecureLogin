package com.example.SecureLogin;

public class Main {
    public static void main(String[] args) {
        SplashScreenView splashScreen = new SplashScreenView();
        splashScreen.displaySplashScreen(); 

        UserModel model = new UserModel();
        LoginView loginView = new LoginView();
        RegisterView registerView = new RegisterView();

        new RegisterController(model, registerView, loginView);
        new LoginController(model, loginView);

        registerView.setVisible(true);  
    }
}
