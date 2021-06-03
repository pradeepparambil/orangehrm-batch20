package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class PayGradePage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtPayGrade = "payGrade_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnCancel = "btnCancel";
    private final String xpNewPayGrade = "//a[text()='XXX']";

    public PayGradePage(WebDriver driver) {
        super(driver);
    }

    public void addNewPayGrade(String payGrade) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtPayGrade), payGrade);
        //super.sendkeys(By.id(idTxtPayGrade), payGrade);
        super.click(By.id(idBtnSave));
        super.click(By.id(idBtnCancel));


        Assert.assertTrue(super.isElementVisible(By.xpath(xpNewPayGrade.replace("XXX",payGrade))),
               "The new PayGrade is not added");
    }
}
