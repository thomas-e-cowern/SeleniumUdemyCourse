package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverMac {

	public static void main(String[] args) {
		
		WebDriver driver = new SafariDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseURL);

	}

}
