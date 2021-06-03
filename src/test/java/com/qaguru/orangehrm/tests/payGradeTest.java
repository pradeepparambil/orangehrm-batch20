package com.qaguru.orangehrm.tests;

import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import com.qaguru.orangehrm.pages.PayGradePage;
import org.testng.annotations.Test;

import java.util.UUID;

public class payGradeTest extends TestBase {
    @Test
    public void addPayGrade(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);

       PayGradePage paygradePage = new PayGradePage(driver);
        paygradePage.addNewPayGrade("AA_"+ UUID.randomUUID());

    }
}
