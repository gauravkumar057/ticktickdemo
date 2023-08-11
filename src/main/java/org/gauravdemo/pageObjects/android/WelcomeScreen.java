package org.gauravdemo.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WelcomeScreen extends BasePage{
	
	AndroidDriver driver;
	
	public WelcomeScreen(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.ticktick.task:id/btn_adept")
	private WebElement LogInbtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/tv_title")
	private WebElement WelcomeTitle;
	
	
	
	public void verifyLogInNowBtnEnable() throws InterruptedException {
		Assert.assertTrue(LogInbtn.isEnabled());
		ExtentManager.getExtentTest().pass("Verify LogIn Now button Enable");
		//ExtentLogger.pass("Verify LogIn Now button Enable");
		Thread.sleep(5000);
	}
	
	
	public void clickLogInNowBtn()
	{
		//LogInbtn.click(); // Clicks the LogIn Now button
		//ExtentManager.getExtentTest().pass("Click Log In Now button");
		//ExtentLogger.pass("Click Log In Now button");
		click(LogInbtn, WaitStrategy.CLICKABLE, "Log In button");
		//return new SignInScreen(driver); // Returns a new instance of the SignInScreen representing the screen after clicking the button
	}
	
	
	public void verifyWelcomeTitle(String Title)
	{
		//String welcometitle = WelcomeTitle.getText();
		Assert.assertEquals(WelcomeTitle.getText(), Title);
		ExtentManager.getExtentTest().pass("Verify Welcome Title");
		getText(WelcomeTitle, WaitStrategy.PRESENCE);
	}
	
	
}

	









