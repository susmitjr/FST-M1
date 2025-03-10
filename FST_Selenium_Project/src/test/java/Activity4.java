package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void websitessecondheading() {
		driver.get("https://alchemy.hguy.co/jobs");
		WebElement Heading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2"));
		String Heading2 = Heading.getText();
		System.out.println("SecondHeading is :" + Heading2);
		Assert.assertEquals(Heading2, "Quia quis non");
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}
}
