package com.qaguru.orangehrm.models;

public class Nationality {
    private String userName;
    private String password;
    private String[] nationalities;

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

    public String[] getNationalities() {
        return nationalities;
    }

    public void setNationalities(String[] nationalities) {
        this.nationalities = nationalities;
    }
}
