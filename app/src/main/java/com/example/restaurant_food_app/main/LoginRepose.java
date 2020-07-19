package com.example.restaurant_food_app.main;

public class LoginRepose {

    private boolean error;
    private String message;
    private Login login;

    public LoginRepose(boolean error, String message, Login login) {
        this.error = error;
        this.message = message;
        this.login = login;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Login getLogin() {
        return login;
    }
}
