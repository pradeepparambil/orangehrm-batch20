package com.qaguru.orangehrm.models;

public class Language {
    private String userName;
    private String password;
    private String[] languages;



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

    public String[] getLanguages() {
        return languages;
    }


    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
