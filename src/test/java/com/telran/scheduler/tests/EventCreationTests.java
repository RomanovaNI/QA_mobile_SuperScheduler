package com.telran.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {


    @Test
    public void eventCreationOfRegisteredUserTest() throws InterruptedException {
        int quantityBeforeAdding;
        int quantityAfterAdding;


        if (!app.event().isNavPanelPresent()) {
            app.user().defaultlogin();
        }

        app.event().tapOnPlusButton();
        quantityBeforeAdding = app.event().getTotalEvents();
        app.event().tapOnPencilButton();
        // Thread.sleep(10000);
        app.event().fillEventForm("Event17", "2", 1, "20");
        app.event().saveEvent();
        quantityAfterAdding = app.event().getTotalEvents();
        Assert.assertEquals(quantityAfterAdding, quantityBeforeAdding + 1);
    }

    @Test
    public void eventCreationOfUnregisteredUserTest() {
        //precond
        if (!app.event().isWizardTitlePresent()) {
            app.user().registerNewProfile();
        }
       // app.profile().selectCurrency(3);
        app.profile().selectCurrencyBySwipe("Belarusian ruble");
        app.profile().tapOnArrow();
        app.profile().typeWage("11");
        app.profile().tapOnNextButton();

        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        app.event().fillEventForm("Event01", "1", 3, "33");
        app.event().saveEvent();
    }
}
