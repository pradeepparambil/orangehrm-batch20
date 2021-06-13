package com.qaguru.orangehrm.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.models.EmpStatus;
import com.qaguru.orangehrm.pages.EmploymentStatusPage;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
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


    @Test(dataProvider = "addEmpStatus", dataProviderClass = EmploymentStatusTestData.class)
    public void editEmpStatusParameterized(String statusFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(statusFile);
        ObjectMapper mapper = new ObjectMapper();
        EmpStatus status = mapper.readValue(url, EmpStatus.class);

        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(status.getUserName(), status.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EMPLOYMENT_STATUS);

        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(driver);
        for (String stat : status.getStatus()) {
            String statusname = stat + UUID.randomUUID();
            employmentStatusPage.addNewEmpStatus(statusname);
            employmentStatusPage.editEmpStatus(statusname, statusname.split("-")[0] + " edited format");

        }
    }
}
