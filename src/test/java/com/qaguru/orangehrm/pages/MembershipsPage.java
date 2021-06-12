package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MembershipsPage extends PageBase {

    private final String idBtnAdd = "btnAdd";
    private final String idTxtMemberships = "membership_name";
    private final String idBtnSave = "btnSave";
    private final String xpNewMemberships = "//a[text()='xxx']";
    private final String xpChkDelete = "//a[text()='xxx']//preceding::input[@name='chkSelectRow[]'][1]";
    private final String idBtnDelete = "btnDelete";
    private final String idBtnConfirmOk = "dialogDeleteBtn";
    private final String xpClkMemberships = "//a[text()='xxx']";
    private final String idTxtForEditMemberships = "membership_name";

    public MembershipsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewMemberships(String memberships) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtMemberships), memberships);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpNewMemberships.replace("xxx", memberships))),
                "The new Memberships is not added");
    }

    public void deleteMemberships(String memberships) {

        super.click(By.xpath(xpChkDelete.replace("xxx", memberships)));
        super.click(By.id(idBtnDelete));
        super.click(By.id(idBtnConfirmOk));
        Assert.assertFalse(super.isElementVisible(By.xpath(xpNewMemberships.replace("xxx", memberships))),
                "The memberships is not deleted");
    }

    public void editMemberships(String memberships, String newMemb) {
        super.click(By.xpath(xpClkMemberships.replace("xxx", memberships)));
        super.setText(By.id(idTxtForEditMemberships), newMemb);
        super.click(By.id(idBtnSave));
       // Assert.assertTrue(super.isElementVisible(By.xpath(xpNewMemberships.replace("xxx", newMemb))), "The membership is not edited");

    }
}
