package com.qaguru.orangehrm.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaguru.orangehrm.library.TestBase;
import com.qaguru.orangehrm.models.Nationality;
import com.qaguru.orangehrm.models.PayGrade;
import com.qaguru.orangehrm.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class payGradeTest extends TestBase {
    @Test
    public void addNewPayGrade(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);

       PayGradePage newPayGrade = new PayGradePage(driver);
        newPayGrade.addNewPayGrade("AA_"+ UUID.randomUUID());

    }

    @Test
    public void deletePayGrade(){
        String username = "admin";
        String password = "admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);

        PayGradePage payGradePage = new PayGradePage(driver);
        String payGrade = "AA_"+ UUID.randomUUID();

        payGradePage.addNewPayGrade(payGrade);
        payGradePage.deletePayGrade(payGrade);


    }


    @Test(dataProvider = "addPayGrade", dataProviderClass = payGradeTestData.class)
    public void addPayGradeParameterized(String payGradeFile) throws IOException {
        URL url = getClass().getClassLoader().getResource(payGradeFile);
        ObjectMapper mapper = new ObjectMapper();
        PayGrade paygrades = mapper.readValue(url,PayGrade.class);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(paygrades.getUserName(), paygrades.getPassword());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);

       PayGradePage paygradepage = new PayGradePage(driver);
        for (String pay : paygrades.getPayGrades()) {
            paygradepage.addNewPayGrade(pay + UUID.randomUUID());
        }

    }


}

