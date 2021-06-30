package com.telran.scheduler.fw;

import com.telran.scheduler.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserHelper extends HelperBase {

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        //  waitForElement(By.id("log_email_input"),10);
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        driver.hideKeyboard();
        tap(By.id("login_btn"));
        Assert.assertTrue(isElementPresent(By.id("wizard_settings_title")));
    }
}
