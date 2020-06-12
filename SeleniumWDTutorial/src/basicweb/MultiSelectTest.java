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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectTest {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new SafariDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select select = new Select(element);
		
		Thread.sleep(1000);
		System.out.println("Selecting orange by value");
		select.selectByValue("orange");
		
		Thread.sleep(1000);
		System.out.println("Deselecting orange by value");
		select.deselectByValue("orange");
		
		Thread.sleep(1000);
		System.out.println("Selecting apple by index");
		select.selectByIndex(0);
		
		Thread.sleep(1000);
		System.out.println("Selecting peach by visible text");
		select.selectByVisibleText("Peach");
		
		Thread.sleep(1000);
		System.out.println("Deselect everything");
		select.deselectAll();
		
		Thread.sleep(1000);
		System.out.println("Print out list of options");
		List<WebElement> options = select.getOptions();
		int size = options.size();
		for (int i = 0; i < size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Done with select elements");
	}

}
