package basicweb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed BeforeClass...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed AfterClass...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executed BeforeSetUp...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executed AfterTeardown...");
	}

	@Test
	public void test1() {
		System.out.println("Executed test1...");
	}
	
	@Test
	public void test2() {
		System.out.println("Executed test2...");
	}

}
