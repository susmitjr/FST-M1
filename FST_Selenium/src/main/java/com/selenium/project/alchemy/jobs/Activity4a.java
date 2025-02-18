package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4a {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://www.training-support.net");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
        System.out.println(driver.getTitle());

        driver.close();

    }
}