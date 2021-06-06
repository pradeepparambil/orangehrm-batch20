package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LanguagePage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtForLanguage = "language_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnDelete = "btnDel";
    private final String xpCreateNewLanguage = "//a[text()='xxx']";
    private final String xpChkDelete = "//a[text()='XXX']//preceding::input[@name='chkListRecord[]'][1]";
    private final String xpClkLanguage = "//a[text()='xxx']";
    private final String idTxtForEditLanguage = "language_name";


    public LanguagePage(WebDriver driver){
        super(driver);
    }

    public void createNewLanguage(String language) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtForLanguage),language);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpCreateNewLanguage.replace("xxx",language))),"The new language is not added");

    }

    public void deleteLanguage(String language) {

        super.click(By.xpath(xpChkDelete.replace("XXX",language)));
        super.click(By.id(idBtnDelete));
        Assert.assertFalse(super.isElementVisible(By.xpath(xpCreateNewLanguage.replace("xxx",language))),"The new language is not deleted");
    }

    public void editLanguage(String language,String newLang){
        super.click(By.xpath(xpClkLanguage.replace("xxx",language)));
        super.setText(By.id(idTxtForEditLanguage),newLang);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpCreateNewLanguage.replace("xxx",newLang))),"The language is not edited");




    }
}


