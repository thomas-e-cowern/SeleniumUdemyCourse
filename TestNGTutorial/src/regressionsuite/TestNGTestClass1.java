package regressionsuite;

import org.testng.annotations.Test;

import base.BaseTestSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGTestClass1 extends BaseTestSuite {
  
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass1 -> This runs once before class1");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass1 -> This runs once after class1");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass1 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass1 -> This runs after every method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_TestClass1 -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_TestClass1 -> testMethod2");
	}

}
