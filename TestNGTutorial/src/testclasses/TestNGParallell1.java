package testclasses;

import org.testng.annotations.Test;

public class TestNGParallell1 {
  
	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("TestNG_Parallel1 -> testMethod1");
		Thread.sleep(6000);
		System.out.println("TestNG_Parallel1 -> testMethod1 -> More Steps");
	}
	
	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG_Parallel1 -> testMethod2");
		Thread.sleep(6000);
		System.out.println("TestNG_Parallel1 -> testMethod2 -> More Steps");
	}
	
}
