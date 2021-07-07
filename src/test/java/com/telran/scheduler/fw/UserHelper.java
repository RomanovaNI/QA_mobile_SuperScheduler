package com.telran.scheduler.fw;

import com.telran.scheduler.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

public class UserHelper extends HelperBase {

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        //  waitForElement(By.id("log_email_input"),10);
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        hideKeyboard();
        tap(By.id("login_btn"));
        //  Assert.assertTrue(isElementPresent(By.id("wizard_settings_title")));
    }

    public void defaultlogin() {
        login(new User().setEmail("kk89@ll.ua").setPassword("12345678Ll"));

    }
    public void registerNewProfile() {
        Random random=new Random();
        int r= random.nextInt(1000);
        login(new User().setEmail("new"+r+"@new.new").setPassword("New12345678"));

    }

    public void fillLoginForm(User user) {
        waitForElementandType(By.id("log_email_input"), 5, user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
    }
}
