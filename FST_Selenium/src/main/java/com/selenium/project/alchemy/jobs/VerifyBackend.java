package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyBackend {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");

        WebElement uname = driver.findElement(By.id("user_login"));
        uname.sendKeys("root");
        WebElement pass = driver.findElement(By.id("user_pass"));
        pass.sendKeys("pa$$w0rd");

        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click(); Thread.sleep(2000);

        WebElement jobListings = driver.findElement(By.cssSelector("a.menu-icon-job_listing > div:nth-child(3)"));
        jobListings.click();Thread.sleep(2000);

        WebElement addNew = driver.findElement(By.linkText("Add New"));
        addNew.click();Thread.sleep(2000);

        WebElement addTitle = driver.findElement(By.id("post-title-0"));
        addTitle.sendKeys("Super Job");Thread.sleep(2000);
        WebElement publish = driver.findElement(By.xpath("//*[text()='Publish…']"));
        publish.click();Thread.sleep(2000);
        WebElement publishAgain = driver.findElement(By.xpath("//button[text()='Publish']"));
        publishAgain.click();Thread.sleep(2000);

        WebElement verifyJob = driver.findElement(By.xpath("//a[text()='View Job']"));
        verifyJob.click();Thread.sleep(2000);

        driver.close();
    }
}
