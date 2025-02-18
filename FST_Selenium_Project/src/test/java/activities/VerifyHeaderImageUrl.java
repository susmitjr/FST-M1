package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class VerifyHeaderImageUrl {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        List<WebElement>links = driver.findElements(By.tagName("img"));

        for (WebElement ele:  links){
            System.out.println(ele.getAttribute("src"));
            System.out.println(ele.getText());
        }

    }
}
