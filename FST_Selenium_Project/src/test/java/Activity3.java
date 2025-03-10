package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void imageurl() {
		driver.get("https://alchemy.hguy.co/jobs");
		WebElement imageurl = driver.findElement(By.tagName("img"));
		@SuppressWarnings("deprecation")
		String imageURL = imageurl.getAttribute("src");
		System.out.println("URL of the image is :" + imageURL);
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}

}
