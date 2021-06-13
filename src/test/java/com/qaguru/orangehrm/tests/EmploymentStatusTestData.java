package com.qaguru.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class EmploymentStatusTestData {

    @DataProvider(name = "empStatusDetails")
    public Object[][] getLoginDetails() {
        return new Object[][]{
                {"admin", "admin123"}
        };
    }

    @DataProvider(name = "addEmpStatus")
    public Object[][] getEmpDetails() {
        return new Object[][]{
                {"testdata/empstatus.json"}
        };
    }




}
