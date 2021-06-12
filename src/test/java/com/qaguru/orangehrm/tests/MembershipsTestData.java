package com.qaguru.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class MembershipsTestData {

    @DataProvider(name = "getUserDetails")
    public Object[][] getUserDetails() {
        return new Object[][]{
                {"admin", "admin123"}
        };
    }

    @DataProvider(name = "addMemberships")
    public Object[][] getAddMembership() {
        return new Object[][]{
                {"testdata/memberships.json"}
        };
    }

    @DataProvider(name = "deleteMemberships")
    public Object[][] getdeleteMembership() {
        return new Object[][]{
                {"testdata/memberships.json"}
        };

    }

    @DataProvider(name = "editMemberships")
    public Object[][] geteditMembership() {
        return new Object[][]{
                {"testdata/memberships.json"}
        };
    }
}
