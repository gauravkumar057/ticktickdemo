package org.gauravdemo.Reports;

import org.gauravdemo.enums.ConfigProperties;
import org.testng.internal.PropertyUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	/*public static void pass(String message, boolean isScreenshotNeeded) {
	    // Assuming you have a method to get the configuration value based on the ConfigProperties enum
	    String passedStepsScreenshotsValue = getConfigValue(ConfigProperties.PASSEDSTEPSSCREESHOTS);

	    if (passedStepsScreenshotsValue.equalsIgnoreCase("yes") && isScreenshotNeeded) {
	        // Code to take a screenshot should go here
	    }
	}*/

	
		
}
