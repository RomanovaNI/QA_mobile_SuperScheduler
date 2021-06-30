package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }


    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
       /* if (text != null) {
            if (!text.equals(driver.findElement(locator).getText())) {*/
                tap(locator);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
       //     }
     //   }
    }

    public WebElement waitForElement(By locator, int timeOut){

        return new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
