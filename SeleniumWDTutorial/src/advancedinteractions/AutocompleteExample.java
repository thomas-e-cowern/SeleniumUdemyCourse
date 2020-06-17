package advancedinteractions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class AutocompleteExample {
	
	WebDriver driver;
	String baseUrl = "http://www.goibibo.com/";
	WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
//		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void test() throws InterruptedException {
		String partialText = "Del";
		String textToSelect = "Delhi, India(DEL)";
		
		WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));	
		textField.sendKeys(partialText);
		
		Thread.sleep(2000);
		WebElement ulElement = driver.findElement(By.id("react-autosuggest-1"));
		
		String innerHTML = ulElement.getAttribute("innerHTML");
		System.out.println(innerHTML);
		
		List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
		Thread.sleep(3000);
		
		for (WebElement element : liElements) {
			System.out.println(element.getText());
			if (element.getText().contains(textToSelect)) {
				System.out.println("Selected: " + element.getText());
				element.click();
				break;
			}
		}
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
//		driver.quit();
		System.out.println("This test file is completed");
	}
}
