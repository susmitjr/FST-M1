package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriverWait getWait() {
		return wait;
	}
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
