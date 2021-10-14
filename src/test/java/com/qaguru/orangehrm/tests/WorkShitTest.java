package com.qaguru.orangehrm.tests;

import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import com.qaguru.orangehrm.pages.WorkShiftPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class WorkShitTest extends TestBase {
    @Test
    public void addShift() {
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.WORK_SHIFTS);

        WorkShiftPage workshiftPage = new WorkShiftPage(driver);
        workshiftPage.addNewShift("AAA_" + UUID.randomUUID());

    }
   @Test
    public void deleteShift(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.WORK_SHIFTS);

        WorkShiftPage workShiftPage=new WorkShiftPage(driver);
        String shift= "AAA_"+UUID.randomUUID();
        workShiftPage.addNewShift(shift);
        workShiftPage.deleteShift(shift);



    }
}