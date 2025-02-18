package com.selenium.project.alchemy.jobs;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://alchemy.hguy.co/jobs");

        String title = driver.getTitle();
        System.out.println("Check:" + title.contains("Alchemy Jobs – Job Board Application"));
        System.out.println(title);
        driver.close();

    }
}
