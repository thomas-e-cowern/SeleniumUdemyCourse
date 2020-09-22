package pageClasses;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectModel {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(3000);
		SearchPage.navigateToFlightsTab(driver);
		Thread.sleep(1000);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.destinationTextBox(driver).sendKeys("Chicago");
		SearchPage.departureDateTextBox(driver).sendKeys("12/25/2014");
		// Added a line to clear the return date text box
		// before entering the return date, because Expedia by default
		// enters the return date same as the departure date
		SearchPage.returnDateTextBox(driver).clear();
		SearchPage.returnDateTextBox(driver).sendKeys("12/31/2014");
		SearchPage.clickOnSearchButton(driver);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
