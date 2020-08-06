package reports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class SeleniumLoginTestWithScreenshots {
	
	private static WebDriver driver;
	private static String baseUrl;
	static ExtentReports reports;
	static ExtentTest test;

	@BeforeClass
	public static void beforeClass() {
		reports = new ExtentReports("/Users/tcowern/Documents/SeleniumUdemyCourse/EReports/logintest.html");
		test = reports.startTest("Verify Courses Text");
		baseUrl = "http://www.letskodeit.com/";
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		test.log(LogStatus.INFO, "Browser Started");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Website opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.className("ast-button"));
		signupLink.click();
		test.log(LogStatus.INFO, "Click on signup link");
//		
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Enter email");
//		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Enter password");
//		
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
//		
		Thread.sleep(3000);
//		
		WebElement welcomeText = null;
//		
		try {
			welcomeText = driver.findElement(By.xpath("//h1[@class='dynamic-heading margin-bottom-']"));
			test.log(LogStatus.INFO, "Chekcing text");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) {
		
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String filename = getRandomString(10) + ".png";
			String directory = System.getProperty("user.dir") + "//screenshots//";
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(sourceFile, new File(directory + filename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("This test file is completed");
		}

//		driver.quit();
		System.out.println("We're done here!");
		reports.endTest(test);
		reports.flush();
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
