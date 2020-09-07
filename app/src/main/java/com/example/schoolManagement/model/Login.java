package com.example.schoolManagement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login extends ResultState {

    @SerializedName("username")
    @Expose
    private String userName;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("tocken")
    @Expose
    private String tocken;

    public Login(String userName, String password, String tocken) {
        this.userName = userName;
        this.password = password;
        this.tocken = tocken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }


}
