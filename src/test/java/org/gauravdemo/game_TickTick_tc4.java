package org.gauravdemo;

import org.gauravdemo.FrameworkConstant.Constant;
import org.gauravdemo.Listeners.CustomTestListener;
import org.gauravdemo.TickTickTestUtils.BaseTest;
import org.gauravdemo.enums.CategoryType;
import org.gauravdemo.pageObjects.android.AccountSignIn;
import org.gauravdemo.pageObjects.android.InboxScreen;
import org.gauravdemo.pageObjects.android.SignInScreen;
import org.gaurvademo.annotations.FrameworkAnnotation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class game_TickTick_tc4 extends BaseTest{

	public SignInScreen signInScreen;
	public AccountSignIn accountSignIn;
	public InboxScreen inboxScreen;

	@FrameworkAnnotation(author = {"Gaurav" }, category = {CategoryType.REGRESSION })
	@Test(priority = 1) 
	public void LogInTickTickApps() throws InterruptedException
	{
		//ExtentReport.createTest("log in Test");

		// Verify if the Welcome title is displayed correctly on the Welcome screen
		welcomeScreen.verifyWelcomeTitle("Welcome to TickTick");

		// Click the "Log In Now" button on the Welcome screen
		welcomeScreen.clickLogInNowBtn(); 

		// Initialize the SignInScreen object with the driver context
		signInScreen = new SignInScreen(driver);

		// Verify if the "Sign In with Email" option is enabled on the Sign In screen
		signInScreen.verifySignInWithEmailEnable(); 

		// Verify if the "Sign In with Google" option is enabled on the Sign In screen
		signInScreen.verifySignInWithGoogleEnable(); 

		// Click the "Sign In with Email" button on the Sign In screen
		signInScreen.clickSignInwithEmailbtn();

		// Initialize the AccountSignIn object with the driver context
		accountSignIn = new AccountSignIn(driver);

		// Verify if the "Account signin" title is displayed on the Account Sign In screen
		accountSignIn.verifyAccountSignInTitle("Account signin"); 

		// Enter the email ID for login from the Constant class (assuming it contains predefined test data)
		accountSignIn.enterEmailID(Constant.email); 

		// Enter the password for login from the Constant class (assuming it contains predefined test data)
		accountSignIn.enterPassword(Constant.password);

		// Verify if the "Sign In" button is enabled on the Account Sign In screen
		accountSignIn.verifySignInbuttonEnable(); 

		// Click the "Sign In" button to initiate the login process
		accountSignIn.clickSignInbtn();

	}

}
