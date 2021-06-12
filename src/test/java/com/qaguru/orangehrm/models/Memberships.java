package com.qaguru.orangehrm.models;

public class Memberships {

    private String userName;
    private String password;
        private String[] memberships;

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

    public String[] getMemberships() {
        return memberships;
    }

    public void setMemberships(String[] memberships) {
        this.memberships = memberships;
    }
}
