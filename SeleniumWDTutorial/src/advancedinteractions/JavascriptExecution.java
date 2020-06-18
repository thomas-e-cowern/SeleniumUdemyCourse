package advancedinteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

import waittypes.WaitTypes;

public class JavascriptExecution {
	
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
//		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		wt = new WaitTypes(driver);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
//		driver.get(baseUrl);
		js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice\'");
	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(5000);
//		WebElement textBox = driver.findElement(By.id("name"));
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name')");
		textBox.sendKeys("Test");
	}

	@After
	public void tearDown() throws Exception {
//		driver.close();
		System.out.println("This test file is completed");
	}
}
