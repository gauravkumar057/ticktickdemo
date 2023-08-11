package org.gauravdemo.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	 static ExtentReports extentReports;
	
	public static ExtentReports getReporterObject()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Mobile Automation");
		spark.config().setReportName("Test Results");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("Tester", "Gaurav Kumar");
		return extentReports;
	}

}
