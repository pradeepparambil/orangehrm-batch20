package com.qaguru.orangehrm.tests;

import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginTestWithValidUser(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
    }
}
