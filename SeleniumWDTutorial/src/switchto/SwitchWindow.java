package switchto;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class SwitchWindow {
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";
	WaitTypes wt;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();

		wt = new WaitTypes(driver);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.id("openwindow"));
		button.click();

		
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle: windowHandles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("Python");
				driver.close();
				break;
			
			}
		}
		driver.switchTo().window(parentHandle);
		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		System.out.println("This test file is completed");
	}
}
