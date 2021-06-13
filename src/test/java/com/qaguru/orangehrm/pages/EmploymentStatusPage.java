package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class EmploymentStatusPage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtStatus = "empStatus_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnDelete = "btnDelete";
    private final String idBtnDeleteConform = "dialogDeleteBtn";
    private final String xpNewStatus = "//a[text()='XXX']";
    private final String xpChkEmpDelete = "//a[text()='XXX']//preceding :: input[@name='chkSelectRow[]'][1]";
    private final String xpEmpEdit = "//a[contains(text(),'XXX')]";
    private final String idEditTxtStatus = "empStatus_name";


    public EmploymentStatusPage(WebDriver driver) {
        super(driver);
    }

    public void addNewEmpStatus(String status) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtStatus), status);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpNewStatus.replace("XXX", status))),
                "The new status is not added");

    }

    public void deleteNewEmpStatus(String status) {
        super.click(By.xpath(xpChkEmpDelete.replace("XXX", status)));
        super.click(By.id(idBtnDelete));
        super.click(By.id(idBtnDeleteConform));
        Assert.assertFalse(super.isElementVisible(By.xpath(xpNewStatus.replace("XXX", status))),
                "The new status is not deleted");

    }

    public void editEmpStatus(String stat, String status) {
        super.click(By.xpath(xpEmpEdit.replace("XXX", stat)));
        super.setText(By.id(idEditTxtStatus), status);
        super.click(By.id(idBtnSave));
    }

}





