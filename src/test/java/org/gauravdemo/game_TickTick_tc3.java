package org.gauravdemo;

import org.gauravdemo.FrameworkConstant.Constant;
import org.gauravdemo.Listeners.CustomTestListener;
import org.gauravdemo.TickTickTestUtils.BaseTest;
import org.gauravdemo.enums.CategoryType;
import org.gauravdemo.pageObjects.android.AccountSignIn;
import org.gauravdemo.pageObjects.android.InboxScreen;
import org.gauravdemo.pageObjects.android.SignInScreen;
import org.gauravdemo.utils.UploadImageToDeviceUtil;
import org.gaurvademo.annotations.FrameworkAnnotation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(CustomTestListener.class)
public class game_TickTick_tc3 extends BaseTest{

	public SignInScreen signInScreen;
	public AccountSignIn accountSignIn;
	public InboxScreen inboxScreen;

	@FrameworkAnnotation(author = {"Gaurav" }, category = {CategoryType.REGRESSION })
	@Test(priority = 1, dataProvider="getData", groups= {"Regression"}) 
	public void UploadImages(HashMap<String, String> input) throws InterruptedException
	{
		//ExtentReport.createTest("Upload Images");
		
		// Click the "Log In Now" button on the Welcome screen
		welcomeScreen.clickLogInNowBtn(); 

		// Initialize the SignInScreen object with the driver context
		signInScreen = new SignInScreen(driver);

		// Click the "Sign In with Email" button on the Sign In screen
		signInScreen.clickSignInwithEmailbtn();

		// Initialize the AccountSignIn object with the driver context
		accountSignIn = new AccountSignIn(driver);

		// Enter the email ID for login from the Constant class (assuming it contains predefined test data)
		accountSignIn.enterEmailID(Constant.email); 

		// Enter the password for login from the Constant class (assuming it contains predefined test data)
		accountSignIn.enterPassword(Constant.password);

		// Click the "Sign In" button to initiate the login process
		accountSignIn.clickSignInbtn();

		// Initialize the InboxScreen object with the driver context
		inboxScreen = new InboxScreen(driver);

		// Click the "Plus" icon to add a new task
		inboxScreen.clickPlusIcon(); 

		// Enter the title for the new task
		inboxScreen.enterTaskTitle("Title of the task"); 

		// Click the calendar icon to set the task's due date
		inboxScreen.clickCalendarIcon(); 

		// Click on the "Tomorrow" button to select the due date as tomorrow
		inboxScreen.clickOnTmrwbtn(); 

		// Click on the priority icon to set the task's priority
		inboxScreen.clickOnPriorityIcon(); 

		// Enter the priority for the task (assumed to be provided via input data)
		inboxScreen.enterPriority(input.get("priority")); 

		// Enter the hashtag for the task (assumed to be provided via input data)
		inboxScreen.enterHashTag(input.get("hashTag")); 

		// Click the "Send" button to create and save the new task with the provided details
		inboxScreen.clickSendbtn();

		// Click on the "To Inbox" button to navigate to the Inbox screen if enabled
		inboxScreen.clickToInboxEnable();

		// Click on the title of the task to view its details
		inboxScreen.clickOnTaskTitle();

		// Click on the "Subtask" button to add a subtask to the current task
		inboxScreen.clickSubTask();

		// Enter the task description as "Test Description Second"
		inboxScreen.enterTaskDescription("Test Description Second");

		// Click on the title of a task to view its details
		inboxScreen.clickOnTaskTitle();

		// Click on the "More Options" button to access additional options for the task
		inboxScreen.clickMoreOptions();

		// Click on the "Photo" button to add a photo to the task
		inboxScreen.clickPhotobtn();

		// Click on the "Next" button to proceed with the storage permission (assuming it's a multi-step process)
		inboxScreen.clickStoragePermissionNext();

		// Click on the "Allow" button to grant access to photos in the device storage
		inboxScreen.clickAccessPhotosAllow();

		UploadImageToDeviceUtil.uploadImage(driver);

		// Click on the "Main Menu" button to navigate back to the main menu or home screen
		inboxScreen.clickMainMenu();

		// Click on the "Downloads" section in the main menu
		inboxScreen.clickDownloads();

		// Select images in the Downloads section (probably to add to the task)
		inboxScreen.selectImagesInDownloads();

		// Click on the "Select" button (assuming to confirm the selection of images)
		//inboxScreen.clickSelectbtn();

		// Click on the title of the task again, perhaps to view additional details or edit it
		inboxScreen.clickOnTaskTitle();

	}


	//	@SuppressWarnings("deprecation")
	//	@BeforeMethod
	//	public void preSetup()
	//	{
	//		Activity activity = new Activity("com.ticktick.task", "com.ticktick.task.activity.DispatchActivity");
	//		driver.startActivity(activity);
	//	}

	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+ "//src//test//java//org//gauravdemo//TestData//tickTick.json");
		return new Object[][] {  {data.get(0)}  };

		//return new Object[][] {  {"Low Priority ", "GK "}  };
	}

}
