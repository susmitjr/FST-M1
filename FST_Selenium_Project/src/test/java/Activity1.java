package seleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void verifywebsitetitle() {
		driver.get("https://alchemy.hguy.co/jobs");
		String titletext = driver.getTitle();
		System.out.println("title of the page is :" + titletext);
		Assert.assertEquals(titletext, "Alchemy Jobs – Job Board Application");
		Reporter.log("Expected result matches with actual result");
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}
}
