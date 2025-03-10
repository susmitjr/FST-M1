package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AlertTestSteps {
    
    WebDriver driver;
    WebDriverWait wait;
    
    @Given("User is on the page")
    public void givenUserIsOnThePage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
        driver.get("https://training-support.net/webelements/alerts");
    }
    
    @When("User clicks the Simple Alert button")
    public void whenUserClicksSimpleAlertButton() {
        WebElement simpleAlertButton = driver.findElement(By.id("simple"));
        simpleAlertButton.click();
    }
    
    @When("User clicks the Confirm Alert button")
    public void whenUserClicksConfirmAlertButton() {
        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
    }
    
    @When("User clicks the Prompt Alert button")
    public void whenUserClicksPromptAlertButton() {
        WebElement promptAlertButton = driver.findElement(By.id("prompt"));
        promptAlertButton.click();
    }
    
    @Then("Alert opens")
    public void thenAlertOpens() {
        Alert alert = driver.switchTo().alert();
    }
    
    @And("Read the text from it and print it")
    public void andReadTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
    }
    
    @And("Write a custom message in it")
    public void andWriteCustomMessageInPrompt() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
    }
    
    @And("Close the alert")
    public void andCloseAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    @And("Close the alert with Cancel")
    public void andCloseAlertWithCancel() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    @And("Read the result text")
    public void andReadResultText() {
        WebElement resultText = driver.findElement(By.id("result"));
        System.out.println("Result text: " + resultText.getText());
    }
}
