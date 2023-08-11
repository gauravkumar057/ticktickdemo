package org.gauravdemo.TickTickTestUtils;

//import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.gauravdemo.pageObjects.android.WelcomeScreen;
import org.gauravdemo.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends AppiumUtils{
	
	public AndroidDriver driver;

	public WelcomeScreen welcomeScreen;
	
	public Properties prop;
	
	/**
	 * Method that runs before the test class to configure Appium and set up the AndroidDriver.
	 * @throws IOException
	 */

	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException
	{
		// Create a new Properties object to store key-value pairs.
		prop = new Properties();
		
		// Use FileInputStream to read the "data.properties" file located in the project's source directory.
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//gauravdemo//properties//data.properties");
		
		//String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		
		// Load the data from the "data.properties" file into the Properties object.
		prop.load(fis);
		
		// Retrieve the value associated with the "ipAddress" key from the Properties object.
		String ipAddress = prop.getProperty("ipAddress");
		//System.out.println(ipAddress);
		
		// Retrieve the value associated with the "port" key from the Properties object.
		String port = prop.getProperty("port");
		
	
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
//		service = startAppiumServer(ipAddress, port);


		
		// Create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		//options.setChromedriverExecutable("C:\\Users\\Gaurav Kumar\\Desktop\\Sel Jars\\Chrome\\Chrome 83 driver\\chromedriver.exe");
		
		options.setApp(System.getProperty("user.dir")+"//src//test//java//org//gauravdemo//resources//ticktick.task.apk");
		//options.setApp("C://Users//Gaurav Kumar//Workspace//TickTickFrameworkDesign//src//test//java//org//gauravdemo//resources//ticktick.task.apk");
		
		// Set other desired capabilities
		options.setCapability("udid","emulator-5554");
		options.setCapability("plateformName","Android");
		options.setCapability("plateformVersion","11.0.0");
		options.setCapability("appPackage", "com.ticktick.task");
		options.setCapability("appActivity", "com.ticktick.task.activity.DispatchActivity");
//		options.setCapability("appActivity", "com.ticktick.task.userguide.UserGuideActivity");
		
		// Initialize AndroidDriver
		System.out.println(service.getUrl());
		System.out.println(options);
		driver = new AndroidDriver(service.getUrl(), options);
		System.out.println(service.getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		// Initialize WelcomeScreen
		welcomeScreen = new WelcomeScreen(driver);
		
	}

//	public AppiumDriverLocalService startAppiumServer(String ipAddress, String port) {
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withIPAddress(ipAddress)
//				.usingPort(Integer.parseInt(port))
//				.build();
//		service.start();
//		return service;
//	}
	
	/**
	 * Method that runs after the test class to tear down the AndroidDriver and stop the Appium service.
	 */
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit(); // Quit the AndroidDriver
		service.stop(); // Stop the Appium service
	}
	
	/*@BeforeSuite
	public void setUpSuite() {
		ExtentReport.initReports();
	}
	
	@AfterSuite
	public void tearDownSuite() throws IOException {
		ExtentReport.flushReports();
	}*/
	
	
	/*@BeforeMethod
	protected void setUp() {
		//Driver.initDriver();
	}
	
	@AfterMethod
	protected void tearDown(ITestResult result) {
		//Driver.quitDriver();
	}*/

}
