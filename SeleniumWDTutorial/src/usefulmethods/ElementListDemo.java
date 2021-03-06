package usefulmethods;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

public class ElementListDemo {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
//		driver = new SafariDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
//		System.out.println("Element of attribute is " + elementText);
		int size = elementList.size();
		System.out.println("List size is " + size);
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
		System.out.println("Done with select elements");
	}

	

}
