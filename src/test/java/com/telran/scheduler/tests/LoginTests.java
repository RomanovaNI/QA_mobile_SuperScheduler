package com.telran.scheduler.tests;

import com.telran.scheduler.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void registrationPositiveTest() {
    //   app.user().waitForElement(By.id("log_email_input"),20);

        app.user().login(new User().setEmail("kk8@ll.ua").setPassword("12345678Ll"));
        Assert.assertTrue(app.event().isWizardTitlePresent());


    } @Test
    public void loginPositiveTest() {
    //   app.user().waitForElement(By.id("log_email_input"),20);

        app.user().login(new User().setEmail("kk89@ll.ua").setPassword("12345678Ll"));
        Assert.assertTrue(app.event().isNavPanelPresent());


    }

    //login_btn
}
