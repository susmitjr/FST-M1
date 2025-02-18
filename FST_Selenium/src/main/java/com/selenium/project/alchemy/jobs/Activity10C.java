package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10C {

    public static void main (String [] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/drag-drop");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1  = driver.findElement(By.id("droppable"));
        WebElement dropzone2  = driver.findElement(By.id("dropzone2"));


        Actions dragdrop = new Actions(driver);
        dragdrop.dragAndDrop(ball, dropzone1).build().perform();

        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
        System.out.println("Entered Drop1");

        dragdrop.dragAndDrop(ball, dropzone2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2, "background-color"));
        System.out.println("Entered Drop2");

        driver.close();




    }
}
