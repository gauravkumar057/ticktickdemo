package org.gauravdemo.Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.gauravdemo.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	private static ExtentReports extent;

	public static void initReports(){
		if(Objects.isNull(extent)) {
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//extent-test-output//index.html");
			//	ExtentSparkReporter spark = new ExtentSparkReporter(Constant.getExtentReportFilePath());
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Tick-Tick Report");
			spark.config().setReportName("Mobile Automation Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Gaurav Kumar ExtentReport");

		}

	}

	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		File reportFile = new File(System.getProperty("user.dir") + "//extent-test-output//index.html");
		if (reportFile.exists()) {
			Desktop.getDesktop().browse(reportFile.toURI());
			//Desktop.getDesktop().browse(new File(Constant.getExtentReportFilePath()).toURI());

		}
	}

	public static void createTest(String testcasename)
	{
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}

	public static void addAuthor(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}

	}

	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}

	}
}

