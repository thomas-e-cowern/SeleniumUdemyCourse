package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestSuite {

	@BeforeClass
	public void beforeClass() {
		System.out.println("base test suite -> before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("base test suite -> after class");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("base test suite -> before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("base test suite -> after test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("base test suite -> before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nbase test suite -> after suite");
	}

}
