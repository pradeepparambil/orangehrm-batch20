package com.qaguru.orangehrm.tests;

import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.EmploymentStatusPage;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import org.testng.annotations.Test;

import java.util.UUID;

public class EmploymentStatusTest extends TestBase {
    @Test
    public void addEmpStatus() {
        String username = "admin";
        String password = "admin123";
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(username, password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EMPLOYMENT_STATUS);

        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(driver);
        employmentStatusPage.addNewEmpStatus("AA_" + UUID.randomUUID());
    }

    @Test
    public void deleteEmpStatus() {
        String username = "admin";
        String password = "admin123";
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(username, password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EMPLOYMENT_STATUS);

        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(driver);
        String status = "AA_" + UUID.randomUUID();
        employmentStatusPage.addNewEmpStatus(status);

        employmentStatusPage.deleteNewEmpStatus(status);
    }


}
