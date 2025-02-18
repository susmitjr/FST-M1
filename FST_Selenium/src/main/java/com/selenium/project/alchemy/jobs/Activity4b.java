package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4b {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://www.training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys("Dr.");
        lastName.sendKeys("Moumita");
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("test@example.com");
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

    }
}