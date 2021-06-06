package com.qaguru.orangehrm.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.models.Nationality;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import com.qaguru.orangehrm.pages.NationalityPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class NationalityTest extends TestBase {
    @Test
    public void addNationality(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);

        NationalityPage nationalityPage = new NationalityPage(driver);
        nationalityPage.addNewNationality("AAA_"+UUID.randomUUID());
    }
    @Test
    public void deleteNationality(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);

        NationalityPage nationalityPage = new NationalityPage(driver);
        String nationality = "AAA_"+UUID.randomUUID();
        nationalityPage.addNewNationality(nationality);
        nationalityPage.deleteNationality(nationality);

    }


    @Test(dataProvider = "addNationality", dataProviderClass = NationalityTestData.class)
    public void addNationalityParameterized(String nationalityFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(nationalityFile);
        ObjectMapper mapper = new ObjectMapper();
        Nationality nationality = mapper.readValue(url, Nationality.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(nationality.getUserName(),nationality.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);

        NationalityPage nationalityPage = new NationalityPage(driver);
        for (String nat : nationality.getNationalities()){
            nationalityPage.addNewNationality(nat+UUID.randomUUID());
        }

    }


}
