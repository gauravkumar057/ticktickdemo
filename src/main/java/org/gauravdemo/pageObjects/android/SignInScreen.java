package org.gauravdemo.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignInScreen extends BasePage {
	
	AndroidDriver driver;
	
	public SignInScreen(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.ticktick.task:id/tv_email_login_title")
	private WebElement SignInwithEmail;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/tv_other_login_title")
	private WebElement SignInwithGoogle;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/iv_logo")
	private WebElement TickTickLogo;
	
	
	
	public void verifySignInWithEmailEnable()
	{
		Assert.assertTrue(SignInwithEmail.isEnabled());
		ExtentManager.getExtentTest().pass("Verify SignIn With Email Enable");
	}	
	
	
	public void verifySignInWithGoogleEnable()
	{
		Assert.assertTrue(SignInwithGoogle.isEnabled());
		ExtentManager.getExtentTest().pass("Verify SignIn With Google Enable");
	}
	
	
	public void clickSignInwithEmailbtn()
	{
		//SignInwithEmail.click(); // Clicks the "Sign In with Email" button
		//ExtentManager.getExtentTest().pass("Click SignIn with Email button");
		click(SignInwithEmail, WaitStrategy.CLICKABLE, "Sign In with Email button");
		//return new AccountSignIn(driver); // Returns a new instance of AccountSignIn representing the screen after clicking the button
	}
	
	
	public void verifyTickTickLogo()
	{
		System.out.println("Is TickTickLogo displayed? " + TickTickLogo.isDisplayed());
		Assert.assertTrue(TickTickLogo.isDisplayed());
		ExtentManager.getExtentTest().pass("Verify TickTick Logo");
	}
	
	
}

	









