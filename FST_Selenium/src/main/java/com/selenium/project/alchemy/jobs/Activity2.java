package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://www.training-support.net");

        System.out.println("============================");

        WebElement idLocator = driver.findElement(By.id("about-link"));
        System.out.println(idLocator.getText());

        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
        System.out.println(cssLocator.getText());

        WebElement classnameLocator = driver.findElement(By.className("green"));
        System.out.println(classnameLocator.getText());

        WebElement linkLocator = driver.findElement(By.linkText("About Us"));
        System.out.println(linkLocator.getText());
        driver.close();
    }
}

