package seleniumActivities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void beforeclass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void postjob() {
        // Step 1: Navigate to the Job Posting Page
        driver.get("https://alchemy.hguy.co/jobs");
        
        // Step 2: Click on 'Post a Job' Link
        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
        
        // Step 3: Fill in the Job Posting Form
        driver.findElement(By.id("create_account_email")).sendKeys("Unnam.Vinitha@ibm.com");
        driver.findElement(By.id("job_title")).sendKeys("Quality Engineer");
        
        // Select Job Type from Dropdown
        WebElement jobtype = driver.findElement(By.id("job_type"));
        Select dropdown = new Select(jobtype);
        dropdown.selectByIndex(1); // Selecting job type
        
        // Job Description: Use JavaScript Executor to send keys
        WebElement jobDescription = driver.findElement(By.xpath("//textarea[@id='job_description']"));
        
        // Scroll the element into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", jobDescription);
        
        // Wait until the element is interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jobDescription));
        
        // Use JavaScript to send keys if it's not interactable via normal means
        js.executeScript("arguments[0].value='testjob';", jobDescription);
        
        // Fill in the job application URL
        driver.findElement(By.id("application")).sendKeys("https://alchemy.hguy.co/jobs");
        
        // Fill in the company name
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        
        // Step 4: Submit the Job Posting
        driver.findElement(By.cssSelector("input.button:nth-child(4)")).click(); // Clicking on submit job button
        
        // Use XPath for Submit Job Preview Button
        driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click(); // Click on the submit button
        
        // Step 5: Go back to Job Listings Page
        driver.navigate().back();
        
        // Step 6: Click on the 'Jobs' Link to Navigate to Job Listings
        WebElement jobsLink = driver.findElement(By.cssSelector("#menu-item-24 > a:nth-child(1)"));
        jobsLink.click();
        
        // Step 7: Wait for the Job Search Bar to Be Visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
        
        // Step 8: Enter Job Title in Search Bar and Trigger Search
        WebElement jobSearchBar = driver.findElement(By.id("search_keywords"));
        jobSearchBar.sendKeys("testjob");
        
        // Step 9: Wait for the Search Button to Be Clickable and Click It
        WebElement searchButton = driver.findElement(By.id("search_submit"));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        
        // Step 10: Wait for Job Listings to Load After Search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job_listings .job_listing")));
        
        // Step 11: Get All Job Listings and Check if 'testjob' is Displayed
        List<WebElement> jobListings = driver.findElements(By.cssSelector(".job_listings .job_listing"));
        boolean jobDisplayed = false;
        
        // Loop Through Job Listings to Check for 'testjob'
        for (WebElement job : jobListings) {
            if (job.getText().contains("testjob")) {
                System.out.println("Job 'testjob' found: " + job.getText());
                jobDisplayed = true;
                break;
            }
        }

        // Step 12: Output the Result
        if (jobDisplayed) {
            System.out.println("The job 'testjob' is displayed on the page.");
        } else {
            System.out.println("The job 'testjob' is not displayed on the page.");
        }

        // Step 13: Close the Browser
        driver.quit();
    }
}
