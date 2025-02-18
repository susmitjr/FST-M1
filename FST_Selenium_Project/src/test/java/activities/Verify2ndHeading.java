package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Verify2ndHeading {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement xpathLocator = driver.findElement(By.xpath("//h2"));
        System.out.println("Check:" + xpathLocator.getText().contains("Quia quis non"));
        System.out.println(xpathLocator.getText());

        driver.close();

    }

}
