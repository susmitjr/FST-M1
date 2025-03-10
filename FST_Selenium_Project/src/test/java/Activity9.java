package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9{

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initialize Firefox WebDriver (make sure you have GeckoDriver in your PATH)
        driver = new FirefoxDriver();
    }

    @Test
    public void createJobListing() {
        // Step 1: Open the browser and navigate to the login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Step 2: Enter login credentials
        driver.findElement(By.id("user_login")).sendKeys("Unnam.Vinitha@ibm.com"); // Replace with your username
        driver.findElement(By.id("user_pass")).sendKeys("Password"); // Replace with your password
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Step 3: Wait until the dashboard page is loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-my-account")));

        // Step 4: Locate the "Job Listings" menu item and click it
        WebElement jobListingsMenu = driver.findElement(By.xpath("//div[@id='menu-posts-job_listing']"));
        jobListingsMenu.click();

        // Step 5: Locate the "Add New" button and click it
        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        addNewButton.click();

        // Step 6: Fill in the necessary job details (Title, Description, etc.)
        WebElement jobTitleField = driver.findElement(By.id("title"));
        jobTitleField.sendKeys("Software Engineer");

        WebElement jobDescriptionField = driver.findElement(By.id("content"));
        jobDescriptionField.sendKeys("We are looking for a skilled Software Engineer with experience in Java and Selenium.");

        // You can fill in other job fields as needed
        WebElement jobLocationField = driver.findElement(By.id("job_location"));
        jobLocationField.sendKeys("San Francisco, CA");

        WebElement jobTypeField = driver.findElement(By.id("job_listing_type"));
        jobTypeField.sendKeys("Full-time");

        // Step 7: Click the "Publish" button
        WebElement publishButton = driver.findElement(By.id("publish"));
        publishButton.click();

        // Step 8: Wait for the job listing to be published and verify success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'notice success')]")));
        System.out.println("Job listing has been successfully created!");

        // Step 9: Optional: Verify that the listing appears on the "Job Listings" page or on the frontend
        // You can check for the job title in the job listings page or backend to confirm.
    }

    @AfterClass
    public void teardown() {
        // Close the browser window after the test
        driver.close();
    }
}
