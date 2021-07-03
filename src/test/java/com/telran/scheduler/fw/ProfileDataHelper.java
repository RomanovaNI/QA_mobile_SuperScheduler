package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfileDataHelper extends HelperBase {
    public ProfileDataHelper(AppiumDriver driver) {
        super(driver);
    }
    public void tapOnArrow(){
        tap(By.id("wizard_settings_wage_arrow"));
    }
    public void tapOnNextButton(){
        tap(By.id("wizard_settings_next"));
    }

    public void typeWage(String wage){
        tap(By.id("wage_dialog_input"));
        type(By.id("wage_dialog_input"), wage);
        tap(By.id("wage_dialog_ok_btn"));
    }
}
