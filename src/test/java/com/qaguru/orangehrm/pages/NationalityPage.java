package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NationalityPage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtNationality = "nationality_name";
    private final String idBtnSave = "btnSave";
    private final String xpNewNationality = "//a[text()='XXX']";

    public NationalityPage(WebDriver driver) {
        super(driver);
    }

    public void addNewNationality(String nationality) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtNationality),nationality);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpNewNationality.replace("XXX",nationality))),
                "The new nationality is not added");
    }
}
