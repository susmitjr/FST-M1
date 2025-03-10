package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	driver = new FirefoxDriver();
    }
    @Test
    public void Navigate() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobsLink = driver.findElement(By.linkText("Jobs"));
        jobsLink.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Jobs – Alchemy Jobs";
        Assert.assertEquals(actualTitle, expectedTitle, "The page title is incorrect! Test failed.");
        System.out.println("Successfully navigated to the 'Jobs' page. Title is: " + actualTitle);
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
