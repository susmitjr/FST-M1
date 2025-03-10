package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
		driver = new FirefoxDriver();
		driver.get(" https://training-support.net/webelements/login-form");
	}

	@DataProvider(name = "Authentication")
	public Object[][] credentials() {
		return new Object[][] { { "Username", "admin" }, { "password", "password" } };
	}

	@Test(dataProvider = "Authentication")
	public void logintest(String Username,String password) {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
	}
	
	@AfterClass
	public void afterclass() {
		driver.close();
	}

}
