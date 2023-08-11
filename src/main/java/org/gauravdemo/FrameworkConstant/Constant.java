package org.gauravdemo.FrameworkConstant;

import org.gauravdemo.enums.ConfigProperties; // Correct import
import java.lang.System;

public class Constant {
	
	private Constant() {}
	
	public static final String password = "Abc@123";
	public static final String email = "Abc2@gmail.com";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/index.html";
	private static String extentReportFilePath = "";
	
	
	public static String getExtentReportFilePath()
	{
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
        String overrideReports = System.getProperty(ConfigProperties.OVERRIDEREPORTS.name());
        if (overrideReports != null && overrideReports.equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }
}






