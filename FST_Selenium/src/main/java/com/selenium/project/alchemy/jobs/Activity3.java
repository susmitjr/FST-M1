package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main (String [] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://www.training-support.net/selenium/simple-form");

        String pgTitle = driver.getTitle();
        System.out.println (pgTitle);

        WebElement fName = driver.findElement(By.id("firstName"));
        WebElement lName = driver.findElement(By.id("lastName"));

        fName.sendKeys("Susmit");
        lName.sendKeys("Jana");

        driver.findElement(By.id("email")).sendKeys("janasusmit@gmail.com");
        driver.findElement(By.id("number")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.close();



    }
}
