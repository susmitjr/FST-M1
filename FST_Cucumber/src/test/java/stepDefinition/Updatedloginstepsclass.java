package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;

public class Updatedloginstepsclass {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the login page")
    public void givenTheUserIsOnTheLoginPage() {
        // Initialize driver and wait
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
        driver.get("https://training-support.net/webelements/login-form");
    }

    @When("the user enters {string} and {string}")
    public void whenTheUserEntersCredentials(String username, String password) {
        // Locate the username, password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Enter username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        loginButton.click();
    }

    @And("clicks the submit button")
    public void andClicksTheSubmitButton() {
        // This step is now part of the above @When method
        // No need to repeat the click action here.
    }

    @Then("get the confirmation text and verify the message as {string}")
    public void thenVerifyConfirmationText(String expectedMessage) {
        // Retrieve the confirmation text
        WebElement resultText = driver.findElement(By.id("action-confirmation"));
        String actualMessage = resultText.getText();

        // Verify if the actual message contains the expected message
        Assertions.assertEquals("Login failed, message not as expected", actualMessage.contains(expectedMessage));
    }
}
