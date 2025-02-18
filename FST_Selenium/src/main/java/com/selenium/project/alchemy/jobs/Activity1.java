package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get ("https://www.training-support.net");

        String title = driver.getTitle();
        System.out.println(title);
        //driver.close();

    }
}