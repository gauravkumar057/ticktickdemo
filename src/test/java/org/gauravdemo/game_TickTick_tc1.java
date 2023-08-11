package org.gauravdemo;


import org.gauravdemo.Listeners.CustomTestListener;
import org.gauravdemo.TickTickTestUtils.BaseTest;
import org.gauravdemo.enums.CategoryType;
import org.gauravdemo.pageObjects.android.*;
import org.gaurvademo.annotations.FrameworkAnnotation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class game_TickTick_tc1 extends BaseTest{
	
	public SignInScreen signInScreen;
	public AccountSignIn accountSignIn;
	public EmailSignup emailSignUp;
	public InboxScreen inboxScreen;



	
	@FrameworkAnnotation(author = {"Gaurav","Shlomi" }, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION })
	@Test(priority = 1)
	public void CreateNewUser()
	{
		//ExtentReport.createTest("Create New User");
		//ExtentManager.getExtentTest().assignAuthor("Gaurav").assignAuthor("Shlomi").assignCategory("Smoke").assignCategory("REgression");


		// Verify if the Welcome title is displayed correctly
		welcomeScreen.verifyWelcomeTitle("Welcome to TickTick");

		// Click the "Log In Now" button on the Welcome screen
		welcomeScreen.clickLogInNowBtn(); 

		// Initialize the SignInScreen object with the driver context
		signInScreen = new SignInScreen(driver);

		// Verify if the TickTick logo is displayed on the Sign In screen
		signInScreen.verifyTickTickLogo();

		// Verify if the "Sign In with Email" option is enabled on the Sign In screen
		signInScreen.verifySignInWithEmailEnable(); 

		// Click the "Sign In with Email" button on the Sign In screen
		signInScreen.clickSignInwithEmailbtn();

		// Initialize the AccountSignIn object with the driver context
		accountSignIn = new AccountSignIn(driver);

		// Verify if the "Account signin" title is displayed on the Account Sign In screen
		accountSignIn.verifyAccountSignInTitle("Account signin");

		// Click the "Create New Account" button on the Account Sign In screen
		accountSignIn.clickCreateNewAccount();

		// Initialize the EmailSignup object with the driver context
		emailSignUp = new EmailSignup(driver);

		// Verify if the "Email Signup" title is displayed on the Email Signup screen
		emailSignUp.verifyEmailSignupTitle();

		// Enter a new email ID for the account signup process
		emailSignUp.enterNewEmailID();

		// Enter a new password for the account signup process
		emailSignUp.enterNewPassword();

		// Click the "Create Account" button to complete the account signup process
		emailSignUp.clickCreateAccBtn();

		// Initialize the InboxScreen object with the driver context
		inboxScreen = new InboxScreen(driver);

		// Verify if the "Inbox" title is displayed on the Inbox screen
		inboxScreen.verifyInboxTitle("Inbox");
		
	}
	
}
