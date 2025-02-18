package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyJobListings {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement listing = driver.findElement(By.linkText("Post a Job"));
        listing.click();
        Thread.sleep(2000);

        WebElement signIn = driver.findElement(By.linkText("Sign in"));
        signIn.click();
        WebElement uname = driver.findElement(By.id("user_login"));
        uname.sendKeys("root");
        WebElement pass = driver.findElement(By.id("user_pass"));
        pass.sendKeys("pa$$w0rd");
        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click(); Thread.sleep(2000);

        WebElement jTitle = driver.findElement(By.id("job_title"));
        String JobName = "Migration Dev Tester";
        jTitle.sendKeys(JobName);
        WebElement desc = driver.findElement(By.id("job_description_ifr"));
        desc.click();
        desc.sendKeys("Responsible for managing SDLC & STC activities");

        WebElement preview = driver.findElement(By.xpath(" //input[@name='submit_job']"));
        preview.click();Thread.sleep(4000);
        WebElement submitList = driver.findElement(By.id("job_preview_submit_button"));
        submitList.click();

        WebElement jobs = driver.findElement(By.linkText("Jobs"));
        jobs.click();
        Thread.sleep(3000);

        WebElement searchBar = driver.findElement(By.id("search_keywords"));
        searchBar.sendKeys(JobName);
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.className("search_submit"));
        submit.click();
        Thread.sleep(3000);

        WebElement jobTitle = driver.findElement(By.xpath("//h3"));
        jobTitle.click();

        WebElement h1Jobs = driver.findElement(By.xpath("//h1"));
        System.out.println("Job title displayed as: " + h1Jobs.getText());
        System.out.println("Job title matching: " + h1Jobs.getText().contains(JobName));
        Thread.sleep(3000);
        driver.quit();
    }
}
