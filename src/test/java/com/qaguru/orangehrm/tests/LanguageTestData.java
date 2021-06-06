package com.qaguru.orangehrm.tests;

import lombok.Data;
import org.testng.annotations.DataProvider;

public class LanguageTestData {

    @DataProvider(name = "getUserData")
    public Object[][] getUserData() {
        return new Object[][]{
                {"admin", "admin123"},
                {"geethu", "geethu123"}
        };

    }

    @DataProvider(name = "addLanguage")
    public Object[][] getAddLanguage() {
        return new Object[][]{
                {"testdata/language.json"}
        };
    }

    @DataProvider(name = "deleteLanguage")
    public Object[][] getDeleteLanguage() {
        return new Object[][]{
                {"testdata/language.json"}
        };
    }

    @DataProvider(name = "editLanguage")
    public Object[][] getEditLanguage() {
        return new Object[][]{
                {"testdata/language.json"}
        };
    }
}
