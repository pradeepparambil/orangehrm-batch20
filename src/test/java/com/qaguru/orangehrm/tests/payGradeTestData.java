package com.qaguru.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class payGradeTestData {
    @DataProvider(name = "getUserDetails")
    public Object[][] getUserDetails(){
        return new Object[][]{
                {"admin", "admin123"},
                {"john", "john123"}
        } ;
    }

    @DataProvider(name = "addPayGrade")
    public Object[][] getAddPayGrade(){
        return new Object[][]{
                {"testdata/paygrade.json"}
        };
    }
}
