package com.qaguru.orangehrm.tests;

import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import com.qaguru.orangehrm.pages.NationalityPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class NationalityTest extends TestBase {
    @Test
    public void addNationality(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);

        NationalityPage nationalityPage = new NationalityPage(driver);
        nationalityPage.addNewNationality("AA_"+ UUID.randomUUID());

    }
}
