package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private String idLogin = "txtUsername";
    private String idPassword = "txtPassword";
    private String idLoginBtn = "btnLogin";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        setText(By.id(idLogin),username);
        setText(By.id(idPassword),password);
        click(By.id(idLoginBtn));
    }
}

