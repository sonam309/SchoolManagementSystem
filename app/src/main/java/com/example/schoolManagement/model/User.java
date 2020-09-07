package com.example.schoolManagement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User extends ResultState {

    @SerializedName("token")
    @Expose
    private String tocken;

    @SerializedName("username")
    @Expose
    private String userName;

    @SerializedName("password")
    @Expose
    private String password;


    @Override
    public String getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(String status) {
        super.setStatus(status);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(message);
    }

    @Override
    public String getToken() {
        return super.getToken();
    }

    @Override
    public void setToken(String token) {
        super.setToken(token);
    }

    public User(String tocken) {
        this.tocken = tocken;
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }
}



