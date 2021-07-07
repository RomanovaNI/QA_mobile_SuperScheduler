package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileDataHelper extends HelperBase {
    public ProfileDataHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnArrow() {
        tap(By.id("wizard_settings_wage_arrow"));
    }

    public void tapOnNextButton() {
        tap(By.id("wizard_settings_next"));
    }

    public void typeWage(String wage) {
        type(By.id("wage_dialog_input"), wage);
        tap(By.id("wage_dialog_ok_btn"));
    }

    public void selectCurrency(int c) {
        tap(By.id("wizard_settings_currency_arrow"));
        List<WebElement> curreny = driver.findElements(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
        curreny.get(c).click();

    }

    public void selectCurrencyBySwipe(String currency){
        tap(By.id("wizard_settings_currency_arrow"));
        if(!getSelectedCurrency().equals(currency)){
            swipeUp();
            tap(By.xpath("//android.widget.TextView[@text='" + currency+"']"));
        }
    }

    private String getSelectedCurrency() {
        WebElement selectedCurrency=driver.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
        return selectedCurrency.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']")).getText();
    }
}


//wizard_settings_currency_arrow
//resource-id
//com.example.svetlana.scheduler:id/currency_row_title
//com.example.svetlana.scheduler:id/currency_row_root