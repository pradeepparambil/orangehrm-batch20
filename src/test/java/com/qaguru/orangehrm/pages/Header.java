package com.qaguru.orangehrm.pages;

import com.qaguru.orangehrm.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Header extends PageBase {
    String xpMenuBar = "//div[@class='menu']";
    String xpMenuItem = ".//*[text()='XXX']";

    public Header(WebDriver driver) {
        super(driver);
    }

    public void selectMenu(String menu){  //Admin|Nationalities
        List<String> menuItems = Arrays.asList(menu.split("\\|"));
        for (String item:menuItems){
            clickMenu(item);
        }
    }

    private void clickMenu(String item) {
        WebElement weMenuItem =  findElement(By.xpath(xpMenuBar),By.xpath(xpMenuItem.replace("XXX",item)));
        weMenuItem.click();

    }
    public boolean isDisplayed(){
        return super.isDisplayed(By.xpath(xpMenuBar));
    }
}
