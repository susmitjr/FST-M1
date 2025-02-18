package com.appium.project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleTasks {
    AndroidDriver driver;
    int i;
    WebDriverWait wait;

    @BeforeClass
    public void performSetup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.apps.tasks");
        caps.setAppActivity(".ui.TaskListsActivity");
        caps.noReset();

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url , caps);
        System.out.println("Google Task Test Started");
        wait = new WebDriverWait(driver , Duration.ofSeconds(15));
    }

    @Test
    public void taskTest(){

        System.out.println("Adding Google Tasks");

        String content =  "Complete activity with google tasks";

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));

        WebElement createTask = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"));
        createTask.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        WebElement taskCont = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        taskCont.sendKeys(content);

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        WebElement added = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
        added.click();

        WebElement tasksCheck = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        System.out.println("Content of Google Task is: " + content);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        System.out.println("Google Task Test Ends");
    }
}
