package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WorkShiftPage extends PageBase {
    private final String idBtnAdd="btnAdd";
    private final String idBtnSave="btnSave";
    private final String idTxtShift="workShift_name";
    private final String idBtnDelete="btnDelete";
    private final String idBtnConfirmOk="dialogDeleteBtn";
    private final String xpathNewShift="//a[text()='XXX']";
    private final String xpathChkDelete="//a[text()='XXX']//preceding::input[@name='chkSelectRow[]'][1]";





    public WorkShiftPage(WebDriver driver) { super(driver); }


    public  void addNewShift(String shift) {
        super.click(By.id(idBtnAdd));
        super.setText(By.id(idTxtShift),shift);
        super.click(By.id(idBtnSave));
        Assert.assertTrue(super.isElementVisible(By.xpath(xpathNewShift.replace("XXX",shift))),
                "The new shift is not added");



    }

    public void deleteShift(String shift) {
        super.click(By.xpath(xpathChkDelete.replace("XXX",shift)));
        super.click(By.id(idBtnDelete));
        super.click(By.id(idBtnConfirmOk));
        Assert.assertFalse(super.isElementVisible(By.xpath(xpathNewShift.replace("XXX",shift))),
                "The  shift is not deleted");


    }
}
