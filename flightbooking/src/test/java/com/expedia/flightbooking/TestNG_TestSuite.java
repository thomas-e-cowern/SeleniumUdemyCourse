package com.expedia.flightbooking;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageClasses.SearchPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(TestNG_TestSuite.class);

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://www.expedia.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\SeleniumUdemyCourse\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
	}

	@Test
	public void fillBasicInfo() throws Exception {
//		SearchPage.navigateToFlightsTab(driver);
//		SearchPage.fillOriginTextBox(driver, "New York");
//		SearchPage.fillDestinationTextBox(driver, "Chicago");
//		SearchPage.fillDepartureDateTextBox(driver, "12/25/2015");
//		SearchPage.fillReturnDateTextBox(driver, "12/31/2015");
		SearchPage.findGoingToButton(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
