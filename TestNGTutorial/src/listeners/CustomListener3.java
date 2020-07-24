package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener3 implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// <suite> tag starts
		System.out.println("Coming from suite onStart");
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		// <suite> tag ends
		System.out.println("Coming from suite onFinish");
		ISuiteListener.super.onFinish(suite);
	}
	
}
