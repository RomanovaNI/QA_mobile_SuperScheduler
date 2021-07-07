package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class EventsHelper extends HelperBase {
    public EventsHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isWizardTitlePresent() {
        return isElementPresent(By.id("wizard_settings_title"));
    }

    public boolean isNavPanelPresent() {
        return isElementPresent(By.id("sort_options"));
    }

    public void tapOnPlusButton() {
        waitForElementAndTap(By.id("fab_main"), 5);
    }

    public void tapOnPencilButton() {
        tap(By.id("fab_add_event"));
    }

    public void fillEventForm(String evenTitle, String eventType, int breaks, String wage) {
        swipeElementToLeft();
        type(By.id("info_title_input"), evenTitle);
        type(By.id("info_type_input"), eventType);
        hideKeyboard();
        if (breaks > 0) {
            for (int i = 0; i < breaks; i++) {
                tapOnAddBreakButton();
            }
        }
        addWage(wage);
    }

    private void swipeElementToLeft() {
        TouchAction action =new TouchAction(driver);
        Dimension size=driver.manage().window().getSize();

        int y=size.height/5;
        int startX= (int) (size.width*0.8);
        int stopX= (int) (size.width*0.2);

        action.longPress(PointOption.point(startX,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(stopX,y)).release().perform();
    }

    private void addWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"), wage);
        tap(By.id("info_wage_save"));

    }

    public void tapOnAddBreakButton() {
        tap(By.id("info_break_plus_btn"));
    }

    public void saveEvent() {
        tap(By.id("info_save_btn"));
    }

    public int  getTotalEvents(){
        List<WebElement> id=driver.findElements(By.id("row_container_main"));
        int idCount= id.size();
        System.out.println("Total events quantity: "+idCount);
        return idCount;
    }

}
