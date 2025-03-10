package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
WebDriver driver;
@BeforeClass
public void beforeclass() {
	driver= new FirefoxDriver();
}
@Test
public void websiteheading() {
	driver.get("https://alchemy.hguy.co/jobs");
	WebElement Heading=driver.findElement(By.className("entry-title"));
	String Headingtext=Heading.getText();
	System.out.println("Heading of page is:"+Headingtext);
	Assert.assertEquals(Headingtext, "Welcome to Alchemy Jobs");
}
@AfterClass
public void afterclass() {
	driver.close();
}
}
