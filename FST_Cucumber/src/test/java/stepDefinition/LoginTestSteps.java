package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the login page")
    public void givenTheUserIsOnTheLoginPage() {
        // Create driver instance
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
        
        // Open browser with login page
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Given("the user enters username and password")
    public void givenTheUserEntersUsernameAndPassword() {
        // Find username and password fields and enter credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");
    }

    @And("clicks the submit button")
    public void andClicksTheSubmitButton() {
        // Locate the submit button and click it
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @Then("get the confirmation message and verify it")
    public void thenGetTheConfirmationMessageAndVerifyIt() {
        // Wait for the confirmation message to appear
        WebElement confirmationMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );
        
        // Get the confirmation message text and verify it
        String message = confirmationMessage.getText();
        Assertions.assertEquals("Login failed, message not as expected", message.contains("Welcome"));
        
        // Close the browser
        driver.quit();
    }
}
