package com.qaguru.orangehrm.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.models.Language;
import com.qaguru.orangehrm.models.Memberships;
import com.qaguru.orangehrm.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class MembershipsTest extends TestBase {
    /*@Test
    public void addMemberships() {
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);

        MembershipsPage membershipsPage = new MembershipsPage(driver);
        membershipsPage.addNewMemberships("MEMB");
    }*/
    @Test(dataProvider = "addMemberships", dataProviderClass = MembershipsTestData.class)
    public void addMembershipsParameterized(String membershipFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(membershipFile);
        ObjectMapper mapper = new ObjectMapper();
        Memberships memberships = mapper.readValue(url, Memberships.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(memberships.getUserName(), memberships.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);

        MembershipsPage membershipsPage = new MembershipsPage(driver);
        for (String memb : memberships.getMemberships()) {
            membershipsPage.addNewMemberships(memb);
        }
    }


    /*@Test
    public void deleteMemberships(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);

        MembershipsPage membershipsPage = new MembershipsPage(driver);
        String memberships = "MEMB";
        membershipsPage.deleteMemberships(memberships);



    } */
    @Test(dataProvider = "deleteMemberships", dataProviderClass = MembershipsTestData.class)
    public void deleteMembershipsParameterized(String membershipFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(membershipFile);
        ObjectMapper mapper = new ObjectMapper();
        Memberships memberships = mapper.readValue(url, Memberships.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(memberships.getUserName(), memberships.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);

        MembershipsPage membershipsPage = new MembershipsPage(driver);
        for (String memb : memberships.getMemberships()) {
            membershipsPage.deleteMemberships(memb);
        }
    }

    /* @Test(priority = 2,dataProvider = "editMemberships", dataProviderClass = MembershipsTestData.class)
    public void editMembershipsParameterized(String membershipsFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(membershipsFile);
        ObjectMapper mapper = new ObjectMapper();
        Memberships memberships = mapper.readValue(url, Memberships.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(memberships.getUserName(), memberships.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);

        MembershipsPage membershipsPage = new MembershipsPage(driver);
        for (String memb : memberships.getMemberships()) {

            String[] x = memb.split(",");
            MembershipsPage.editMemberships(x[0], x[1]);
        }
    } */
}
