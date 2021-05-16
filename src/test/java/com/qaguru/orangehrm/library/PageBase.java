package com.qaguru.orangehrm.library;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver;
    private final long WAIT_TIME = 5L;
    private static final int DEF_MAX_TRIALS = 10;
    protected static final int REATTEMPT_DELAY = 500;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void setText(By by, String text) {
        WebElement we = new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
        we.clear();
        we.sendKeys(text);
    }
    protected void click(By by){
        WebElement we = new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
        we.click();
    }

    protected WebElement findElement(By parent, By child) {
        WebElement weParent = findElement(parent);
        return weParent.findElement(child);
    }
    protected WebElement findElement(By by){
        WebDriverWait wait = new WebDriverWait(driver,WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected boolean isDisplayed(By by){
        try {
            findElement(by);
            return true;
        }catch (Exception exc){
            return false;
        }
    }
    protected void setCheckBox(By by, boolean check){
        WebElement we = findElement(by);
        if((check && !we.isSelected()) || (!check && we.isSelected())){
            we.click();
        }
    }
    protected void sendkeys(By by,String keys){
        findElement(by).sendKeys(keys);
    }
    protected void selectFromList(By by, String visibleText) {
        WebElement we = findElement(by);
        Select select = new Select(we);
        select.selectByVisibleText(visibleText);
    }
    protected String getText(By by){
        return findElement(by).getText();
    }
}
