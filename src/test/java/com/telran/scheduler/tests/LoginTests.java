package com.telran.scheduler.tests;

import com.telran.scheduler.models.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
    //   app.user().waitForElement(By.id("log_email_input"),20);

        app.user().login(new User().setEmail("ll@ll.ua").setPassword("12345678Ll"));

    }

    //login_btn
}
