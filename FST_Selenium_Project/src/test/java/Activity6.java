package seleniumActivities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
WebDriver driver;
@BeforeClass
public void beforeclass() {
	driver = new FirefoxDriver();
}
@Test
public void Applyjob() {
	driver.get("https://alchemy.hguy.co/jobs/");
	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	WebElement joblist=driver.findElement(By.id("search_keywords"));
	joblist.sendKeys("test");
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)) ;
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job_listings .job_listing")));
    List<WebElement> jobs = driver.findElements(By.cssSelector(".job_listings .job_listing"));
    if(jobs.size()>0) {
    	jobs.get(0).click();
    }
    else {
    	System.out.println("No jobs found");
    }
    driver.findElement(By.cssSelector(".application_button")).click();
    WebElement Emailtext=driver.findElement(By.className("job_application_email"));
    String email=Emailtext.getText();
    System.out.println("Email is :"+email);
}
@AfterClass
public void closebrowser() {
	driver.close();
}
}
