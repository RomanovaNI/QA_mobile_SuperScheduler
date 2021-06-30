package com.telran.scheduler.fw;

import com.telran.scheduler.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
      waitForElement(By.id("log_email_input"),20);
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());

    }
}
