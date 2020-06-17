package advancedinteractions;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class ScreensshotExample {
	
	WebDriver driver;
	String baseUrl = "http://www.facebook.com/";
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
	public void test() {
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
	}
	
	@After
	public void tearDown() throws Exception {
		String filename = getRandomString(10) + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		System.out.println("This test file is completed");
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
