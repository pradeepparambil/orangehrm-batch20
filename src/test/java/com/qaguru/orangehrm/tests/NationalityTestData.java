package com.qaguru.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class NationalityTestData {
    @DataProvider(name = "getUserDetails")
    public Object[][] getUserDetails(){
        return new Object[][]{
                {"admin", "admin123"},
                {"john", "john123"}
        } ;
    }

    @DataProvider(name = "addNationality")
    public Object[][] getAddNationality(){
        return new Object[][]{
                {"testdata/nationality.json"}
        };
    }

}
