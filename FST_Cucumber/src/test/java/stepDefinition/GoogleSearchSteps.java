package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GoogleSearchSteps {
    
    WebDriver driver;  // To store the WebDriver instance
    WebDriverWait wait;  // To wait for elements

    @Given("User is on Google Home Page")
    public void givenUserIsOnGoogleHomePage() {
        // Initialize the driver and wait instance
        driver = new FirefoxDriver();  // You can use ChromeDriver if you prefer Chrome
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));        
        // Open the Google homepage
        driver.get("https://www.google.com");
    }

    @When("User types in {string} and hits ENTER")
    public void whenUserTypesInAndHitsEnter(String searchQuery) {
        // Find the search bar and enter the search query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery);
        searchBox.submit();  // Submit the form (equivalent to hitting ENTER)
    }

    @Then("Show how many search results were shown")
    public void thenShowHowManySearchResultsWereShown() {
        // Wait until the results stats are visible
        WebElement resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        
        // Get the result stats text and print it
        String resultText = resultStats.getText();
        System.out.println("Search results: " + resultText);
        
        // Close the browser after the test
        driver.quit();
    }
}
