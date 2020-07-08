package testclasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBeforeClassAnnotations {
	
	@BeforeClass
	public void setUp () {
		System.out.println("Runs once before class");
	}
	
	@AfterClass
	public void cleanUp () {
		System.out.println("Runs once after class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Running before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Running after method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Running test method 1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Running test method 2");
	}

}
