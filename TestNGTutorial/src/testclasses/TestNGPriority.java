package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGPriority {

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void test1() {
		System.out.println("Test method 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test method 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test method 3");
	}
}
