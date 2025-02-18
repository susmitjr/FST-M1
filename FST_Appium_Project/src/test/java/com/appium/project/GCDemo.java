package com.appium.project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GCDemo {


    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium page
        driver.get("https://www.training-support.net/selenium");
        System.out.println("Server Setup done");
    }

    @Test
    public void scrollIntoViewTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(
                ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        List<WebElement> weList = null;
        weList = driver.findElements(By.className("android.view.View"));
        for (WebElement we : weList) {
            if (we.getText().contains("To-Do")) {
                we.click();
                break;
            }
        }

        //WebElement todoL = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View"));todoL.click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[contains(@text, 'Add Task')]")));

        WebElement input = driver.findElement(AppiumBy.className("android.widget.EditText"));
        input.sendKeys("Test");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'Add Task')]")).click();

        System.out.println("TO DO List created");
        // Locate element
       /*
        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Click Me!")));
        // Print page title
        String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'New Tab')]")).getText();
        System.out.println("Page title is: " + pageTitle);

        // Assertion
        Assert.assertEquals(pageTitle, "New Tab Opener");*/

        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("")));
        //String verifyTODOList = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View")).getText();

        //System.out.println("To Do Lists are... " + verifyTODOList);
        //Assert.assertEquals(verifyTODOList , "Test");
    }

    @AfterClass
    public void afterClass() {
       driver.quit();
        System.out.println("Test Completed!");
    }
}
