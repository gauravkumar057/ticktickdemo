package org.gauravdemo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;

public class ScreenshotUtils {
	
	/**
	 * Takes a screenshot of the current screen and saves it to a specified destination.
	 *
	 * @param testCaseName The name of the test case.
	 * @param driver       The AppiumDriver instance.
	 * @return The file path of the saved screenshot.
	 * @throws IOException If an I/O error occurs during the process.
	 */
	public static String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		//String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		String destinationFile = System.getProperty("user.dir")+"//extent-test-output//"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. Capture and place in the folder //2. extent report pick file and attach to report
	}

}
