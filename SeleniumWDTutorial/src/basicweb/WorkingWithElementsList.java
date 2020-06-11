package basicweb;

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

public class WorkingWithElementsList {
	
	boolean isChecked = false;
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
//		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
		for (int x = 0; x < radioButtons.size(); x++) {
			isChecked = radioButtons.get(x).isSelected();
			
			if(!isChecked) {
				radioButtons.get(x).click();
				Thread.sleep(1000);
			}
		}
		
		for (int x = 0; x < radioButtons.size(); x++) {
			System.out.println("Radio button " + x + " is checked: " + radioButtons.get(x).isSelected());
		}
		
		System.out.println(radioButtons.size());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Done with radio buttons and checkboxes");
	}

	

}
