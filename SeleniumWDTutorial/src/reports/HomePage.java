package reports;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	public void enterEmail (String email) {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		test.log(LogStatus.INFO, "Enter email");
	}
	
	public void enterPassword (String password) {
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
		test.log(LogStatus.INFO, "Enter password");
	}
	
	public void clickGoButton () {
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
	}
	
	public boolean isCoursesTextPresent () {
		WebElement welcomeText = null;
	
		try {
			welcomeText = driver.findElement(By.xpath("//h1[@class='dynamic-heading margin-bottom-20']"));
			test.log(LogStatus.INFO, "Checking text");
			if (welcomeText != null) {
				return true;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return false;
	}
	
	public void login (String email, String password) {
		clickSignupLink();
		enterEmail(email);
		enterPassword(password);
		clickGoButton();
	}
	
}
