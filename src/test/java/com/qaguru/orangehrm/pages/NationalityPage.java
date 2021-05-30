package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NationalityPage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtNationality = "nationality_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnDelete = "btnDelete";
    private final String idBtnConfirmOk = "dialogDeleteBtn";
    private final String xpNewNationality = "//a[text()='XXX']";
    private final String xpChkDelete = "//a[text()='XXX']//preceding::input[@name='chkSelectRow[]'][1]";

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

    public void deleteNationality(String nationality) {

        super.click(By.xpath(xpChkDelete.replace("XXX",nationality)));
        super.click(By.id(idBtnDelete));
        super.click(By.id(idBtnConfirmOk));
        Assert.assertFalse(super.isElementVisible(By.xpath(xpNewNationality.replace("XXX",nationality))),
                "The nationality is not deleted");
    }

}
