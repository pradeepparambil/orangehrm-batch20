package com.qaguru.orangehrm.models;

public class PayGrade {
    private String userName;
    private String password;
    private String[] payGrades;

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

    public String[] getPayGrades() {
        return payGrades;
    }

    public void setPayGrades(String[] payGrades) {
        this.payGrades = payGrades;
    }
}
