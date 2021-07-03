package com.telran.scheduler.tests;

import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {



    @Test
    public void eventCreationOfRegisteredUserTest() throws InterruptedException {
        if (!app.event().isNavPanelPresent()){
        app.user().defaultlogin();
    }
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(10000);
        app.event().fillEventForm("Event157", "2",1,"30");
        app.event().saveEvent();
    }

    @Test
    public void eventCreationOfUnregisteredUserTest(){
       //precond
        if (!app.event().isWizardTitlePresent()) {
            app.user().newProfile();
        }
        //wizard_settings_wage_arrow
        //50
        //wage_dialog_ok_btn
        //wizard_settings_next
        app.profile().tapOnArrow();
        app.profile().typeWage("11");
        app.profile().tapOnNextButton();

        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        app.event().fillEventForm("Event01", "1",3,"33");
        app.event().saveEvent();
    }
}
