package com.qaguru.orangehrm.library;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
}
