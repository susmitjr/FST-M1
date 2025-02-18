package com.selenium.project.alchemy.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyJob {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement jobs = driver.findElement(By.linkText("Jobs"));
        jobs.click();
        Thread.sleep(3000);

        WebElement searchBar = driver.findElement(By.id("search_keywords"));
        searchBar.sendKeys("Banking");
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.className("search_submit"));
        submit.click();
        Thread.sleep(3000);

        WebElement job1 = driver.findElement(By.xpath("//h3"));
        job1.click();
        Thread.sleep(3000);


        WebElement applyJob = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        applyJob.click();
        Thread.sleep(3000);

        WebElement confMsg = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p"));
        System.out.println("Message displayed as: " + confMsg.getText() );
        System.out.println("Message contains email as abc@gmail.com : " + confMsg.getText().contains("abc@gmail.com"));

        driver.quit();
    }
}
