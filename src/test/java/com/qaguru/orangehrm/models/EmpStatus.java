package com.qaguru.orangehrm.models;

public class EmpStatus {
    private String userName;
    private String password;
    private String[] status;


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String[] getStatus() {
        return status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}
