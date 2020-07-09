package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTestSuite {

	@BeforeClass
	public void beforeClass() {
		System.out.println("\nbase test suite -> before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\nbase test suite -> after class");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nbase test suite -> before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nbase test suite -> after suite");
	}

}
