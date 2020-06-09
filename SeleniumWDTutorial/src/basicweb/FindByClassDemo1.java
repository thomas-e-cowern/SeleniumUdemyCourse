package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassDemo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.findElement(By.className("inputs")).sendKeys("Testing");
		

	}

}
