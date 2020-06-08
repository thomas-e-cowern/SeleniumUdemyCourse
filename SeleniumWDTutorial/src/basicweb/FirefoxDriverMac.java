package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverMac {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseURL);
	}

}
