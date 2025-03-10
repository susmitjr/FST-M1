package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Initialize the Firefox WebDriver
        driver = new FirefoxDriver();
    }

    @Test
    public void backendLogin() {
        // Navigate to the login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Enter login credentials
        driver.findElement(By.id("user_login")).sendKeys("Unnam.Vinitha@ibm.com");
        driver.findElement(By.id("user_pass")).sendKeys("Password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Wait for a successful login indication (e.g., a specific element appearing, or a URL change)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Use Duration here
        try {
            // Wait for the admin dashboard or another indicator of a successful login (e.g., the presence of a user profile icon)
            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-my-account")));
            System.out.println("Logged into the application successfully!");
        } catch (Exception e) {
            System.out.println("Login failed or the element indicating successful login was not found.");
        }
    }

    @AfterClass
    public void afterClass() {
        // Close the browser window
        driver.quit();
    }
}
