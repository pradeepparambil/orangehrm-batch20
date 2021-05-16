package com.qaguru.orangehrm.tests;


import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.Header;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import org.testng.annotations.Test;

public class MenuTests extends TestBase {

    @Test
    public void menuTest(){
        LoginPage loginPage = new LoginPage(driver);
        Header header = new Header(driver);
        loginPage.login("admin", "admin123");
        header.selectMenu(MenuOptions.NATIONALITIES);
        System.out.println("test");

    }

}
