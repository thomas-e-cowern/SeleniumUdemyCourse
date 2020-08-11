package reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	ExtentTest test;
	WebDriver driver = null;
	
	public HomePage (WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickSignupLink () {
		WebElement signupLink = driver.findElement(By.className("ast-button"));
		signupLink.click();
		test.log(LogStatus.INFO, "Click on signup link");
	}
	
	public void enterEmail () {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Enter email");
	}
	
	public void enterPassword () {
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Enter password");
	}
	
	public void clickGoButton () {
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
	}
	
}
