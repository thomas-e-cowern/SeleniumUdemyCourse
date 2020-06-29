package actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	WebDriver driver;
	String baseUrl = "https://jqueryui.com/slider/";
	JavascriptExecutor jse;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver;
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(element, 500, 0).perform();
	}


	@After
	public void tearDown() throws Exception {
//		driver.close();
		System.out.println("This test file is completed");
	}
}
