package com.logit.logitapi.requests;

public class RegisterRequest {
    private String email;
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String timezone;
    public String getTimezone() {
        return this.timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}

