package advancedinteractions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class CalendarSelection {
	
	WebDriver driver;
	String baseUrl = "https://www.expedia.com/?pwaLob=wizard-hotel-pwa-v2";
	WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
//		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	
	@Test
	public void test1() throws InterruptedException {
//		driver.get(baseUrl);
		// Click flights tab
		driver.findElement(By.id("d1-btn")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.xpath("//div[@class='uitk-calendar']//div[1]//table[1]//tbody[1]//tr[5]//td[2]//button[1]"));
		// Click departing field
		departingField.click();
		System.out.println("Test 1 done");
	}
	
	@Test
	public void test2() throws InterruptedException {
//		driver.get(baseUrl);
		// Click flights tab
		driver.findElement(By.id("hotel-checkin-hp-hotel")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.xpath("//button[@type='button'][contains(.,'June 29')]"));
		// Click departing field
		departingField.click();
		System.out.println("Test 2 done");

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
//		driver.quit();
		System.out.println("This test file is completed");
	}
}
