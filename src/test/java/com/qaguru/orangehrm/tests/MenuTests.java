package com.qaguru.orangehrm.tests;


import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import org.testng.annotations.Test;


public class MenuTests extends TestBase {

    @Test
    public void menuTest(){
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123");
        headerPage.selectMenu(MenuOptions.NATIONALITIES);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);
        System.out.println("test");

    }

}
