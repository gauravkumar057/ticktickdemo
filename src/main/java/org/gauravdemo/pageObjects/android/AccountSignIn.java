package org.gauravdemo.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountSignIn extends BasePage{
	
	AndroidDriver driver;
	
	public AccountSignIn(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.EditText'])[1]")
	private WebElement EmailID;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.EditText'])[2]")
	private WebElement Password;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/login_in_tv")
	private WebElement SignInbtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/change_to_register_layout")
	private WebElement CreateNewAccount;
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[4]")
	private WebElement AccountSignInTitle;
	
	
	
	public void enterEmailID(String email)
	{
		EmailID.sendKeys(email);
		ExtentManager.getExtentTest().pass("Enter Email ID");
	}
	
	
	public void enterPassword(String password)
	{
		Password.sendKeys(password);
		ExtentManager.getExtentTest().pass("Enter Password");
	}
	
	
	public void clickSignInbtn() throws InterruptedException
	{
		//SignInbtn.click(); // Clicks the Sign In button
		///ExtentManager.getExtentTest().pass("Click SignIn button");
		click(SignInbtn, WaitStrategy.CLICKABLE, "SignIn button");
		Thread.sleep(5000);
		//return new InboxScreen(driver); // Returns a new instance of InboxScreen representing the screen after clicking the button
	}
	
	
	public void clickCreateNewAccount()
	{
		//CreateNewAccount.click(); // Clicks the "Create New Account" element
		//ExtentManager.getExtentTest().pass("Click Create New Account");
		click(CreateNewAccount, WaitStrategy.CLICKABLE, "Create New Account button");
	}
	
	public void verifyAccountSignInTitle(String Title)
	{
		String accountSignInTitle = AccountSignInTitle.getText();
		ExtentManager.getExtentTest().pass("Verify Account SignIn Title");
		Assert.assertEquals(accountSignInTitle, Title);
	}
	
	public void verifySignInbuttonEnable()
	{
		Assert.assertTrue(SignInbtn.isEnabled());
		ExtentManager.getExtentTest().pass("Verify SignIn button Enable");
	}
	
	
}
