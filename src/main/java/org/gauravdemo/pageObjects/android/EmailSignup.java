package org.gauravdemo.pageObjects.android;

import static org.testng.Assert.assertTrue;

import org.gauravdemo.Reports.ExtentLogger;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.utils.GenerateRandomEmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EmailSignup extends BasePage{
	
	AndroidDriver driver;
	
	
	public EmailSignup(AndroidDriver driver)
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[3]")
	private WebElement EmailSignupTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	private WebElement EnterNewEmailID;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password: 6–64 characters']")
	private WebElement EnterNewPassword;
	
	@AndroidFindBy(id="com.ticktick.task:id/email_register_tv")
	private WebElement CreateAccBtn;
	

	public void verifyEmailSignupTitle()
	{
		EmailSignupTitle.getText();
		Assert.assertEquals(EmailSignupTitle.getText(), "Email signup");
		ExtentManager.getExtentTest().pass("Verify TickTick Logo");
	}
	
	public void enterNewEmailID()
	{
//		EnterNewEmailID.sendKeys("Abc11@gmail.com");
		EnterNewEmailID.sendKeys(GenerateRandomEmail.getSaltString()+"@gmail.com");
		ExtentManager.getExtentTest().pass("Enter New Email ID");
	}
	

	public void enterNewPassword()
	{
		EnterNewPassword.sendKeys("Abc@123");
		ExtentManager.getExtentTest().pass("Enter New Password");
	}
	
	
	public void clickCreateAccBtn() 
	{
		CreateAccBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentManager.getExtentTest().pass("Create Account Button");
	}
	
}