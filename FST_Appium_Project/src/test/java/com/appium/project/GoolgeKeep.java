package com.appium.project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoolgeKeep {

    AndroidDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void keepOpen() throws MalformedURLException {
        System.out.println("setup processing");
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.keep");
        caps.setAppActivity(".activities.BrowseActivity");
        caps.noReset();

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url , caps);
        System.out.println("Google keep Test Started");
        wait = new WebDriverWait(driver , Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        System.out.println("Inside Google keep");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/new_note_button")));

        WebElement newButton = driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button"));
        newButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        WebElement title = driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        title.sendKeys("Dummy Test");

        WebElement noteBody = driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        noteBody.sendKeys("This is the description of Dummy test article");

        WebElement goBack = driver.findElement(AppiumBy.accessibilityId("Navigate up"));
        goBack.click();

        // Assertion
        String verifyKeep = driver.findElement(AppiumBy.xpath(
                "//androidx.cardview.widget.CardView[@content-desc=\"Dummy Test. This is the description of Dummy test article. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")
        ).getText();
        Assert.assertEquals(verifyKeep, "Dummy Test");

    }

    @AfterClass
    public void endKeep(){
        driver.quit();
        System.out.println("Test finished");
    }
}
