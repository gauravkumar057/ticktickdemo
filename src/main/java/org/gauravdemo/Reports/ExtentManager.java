package org.gauravdemo.Reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --> private package
		return extTest.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	public static void unload() {
		extTest.remove();
	}
}
