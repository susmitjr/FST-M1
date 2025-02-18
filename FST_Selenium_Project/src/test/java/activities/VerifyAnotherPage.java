package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyAnotherPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement jobs = driver.findElement(By.linkText("Jobs"));
        jobs.click();
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("Check: "+ title.contains("Jobs – Alchemy Jobs"));

        driver.quit();
    }
}
