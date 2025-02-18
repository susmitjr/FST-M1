package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyHeading {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement classnameLocator = driver.findElement(By.className("entry-title"));
        System.out.println("Check:" + classnameLocator.getText().contains("Welcome to Alchemy Jobs"));
        System.out.println(classnameLocator.getText());

        driver.close();

    }
}
