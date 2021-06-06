package com.qaguru.orangehrm.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.models.Language;
import com.qaguru.orangehrm.pages.LanguagePage;
import com.qaguru.orangehrm.pages.HeaderPage;
import com.qaguru.orangehrm.pages.LoginPage;
import com.qaguru.orangehrm.pages.MenuOptions;
import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;


public class LanguageTest extends TestBase {


    @Test(priority = 1, dataProvider = "addLanguage", dataProviderClass = LanguageTestData.class)
    public void addLanguageParameterized(String languageFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(languageFile);
        ObjectMapper mapper = new ObjectMapper();
        Language language = mapper.readValue(url, Language.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(language.getUserName(), language.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CREATE_LANGUAGE);

        LanguagePage languagePage = new LanguagePage(driver);
        for (String lang : language.getLanguages()) {
            String[] x = lang.split(",");
            languagePage.createNewLanguage(x[0]);
        }
    }



    @Test(priority = 2,dataProvider = "editLanguage", dataProviderClass = LanguageTestData.class)
    public void editLanguageParameterized(String languageFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(languageFile);
        ObjectMapper mapper = new ObjectMapper();
        Language language = mapper.readValue(url, Language.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(language.getUserName(), language.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CREATE_LANGUAGE);

        LanguagePage languagePage = new LanguagePage(driver);
        for (String lang : language.getLanguages()) {

            String[] x = lang.split(",");
            languagePage.editLanguage(x[0], x[1]);
        }
    }

    @Test(priority = 3,dataProvider = "deleteLanguage", dataProviderClass = LanguageTestData.class)
    public void deleteLanguageParameterized(String languageFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(languageFile);
        ObjectMapper mapper = new ObjectMapper();
        Language language = mapper.readValue(url, Language.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(language.getUserName(), language.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CREATE_LANGUAGE);

        LanguagePage languagePage = new LanguagePage(driver);
        for (String lang : language.getLanguages()) {
            String[] x = lang.split(",");
            languagePage.deleteLanguage(x[1]);
        }
    }



}


