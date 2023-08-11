package org.gauravdemo.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class InboxScreen extends BasePage {
	
	AndroidDriver driver;
	
	public InboxScreen(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@class='android.widget.ImageButton']")
	private WebElement PlusIcon;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/quick_add_title")
	private WebElement TaskTitle;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/pick_up_time_bg")
	private WebElement CalendarBtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/layout_tomorrow")
	private WebElement CalTmrwbtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/priority_toggle")
	private WebElement Prioritybtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/save_btn_anim")
	private WebElement Sendbtn;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/content")
	private WebElement InboxEnable;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[5]")
	private WebElement ClickTaskTitle;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/list")
	private WebElement SubTaskOpen;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/container")
	private WebElement TaskDescription;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/tag_toggle")
	private WebElement HashTagbtn;
	
	
	@AndroidFindBy(id="candroid:id/autofill_save_no")
	private WebElement Nothanksbtn;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[1]")
	private WebElement InboxTitle;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[5]")
	private WebElement TaskOfTheTitle;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[6]")
	private WebElement CalendarDate;
	
	
	@AndroidFindBy(id="com.ticktick.task:id/itv_close")
	private WebElement PriorityIcon;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.ImageView'])[1]")
	private WebElement MoreOptions;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	@AndroidFindBy(xpath="(//*[@text='Photo'])")
	private WebElement Photobtn;
	
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement StoragePermissionNext;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.Button'])[1]")
	private WebElement AccessPhotosAllow;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.ImageButton'])[1]")
	private WebElement MainMenu;
	
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.LinearLayout'])[3]")
	private WebElement Downloads;

	@AndroidFindBy(xpath="(//*[@class='android.widget.ImageView'])[2]")
	//@AndroidFindBy(id="com.google.android.documentsui:id/icon_thumb")
	private WebElement ImagesInDownloads;

	
	@AndroidFindBy(id="com.google.android.documentsui:id/action_menu_select")
	private WebElement Selectbtn;
	
	
	
	public void clickPlusIcon()
	{
		//PlusIcon.click();
		//ExtentManager.getExtentTest().pass("Click Plus Icon");
		click(PlusIcon, WaitStrategy.CLICKABLE, "Plus Icon");
	}
	
	
	public void enterTaskTitle(String title) throws InterruptedException
	{
		//TaskTitle.sendKeys("Title Of the Task"); 
		//ExtentManager.getExtentTest().pass("Enter Task Title");
		sendKeys(TaskTitle, title, WaitStrategy.PRESENCE, "Enter Task Title");
		Thread.sleep(3000);
	}
	
	
	public void clickCalendarIcon() throws InterruptedException
	{
		//CalendarBtn.click();
		//ExtentManager.getExtentTest().pass("Click Calendar Icon");
		click(CalendarBtn, WaitStrategy.CLICKABLE, "Calendar Icon");
		Thread.sleep(3000);
	}
	
	
	public void clickOnTmrwbtn()
	{
		//CalTmrwbtn.click();
		click(CalTmrwbtn, WaitStrategy.CLICKABLE, "Tomorrow button");
		String CalendarDateSelected = driver.findElement(By.id("com.ticktick.task:id/pick_time_date_num")).getText();
		assertEquals(CalendarDateSelected, "Tomorrow");
		//ExtentManager.getExtentTest().pass("Click On Tomorrow button");
		
	}
	
	
	public void clickOnPriorityIcon()
	{
		//Prioritybtn.click();
		//ExtentManager.getExtentTest().pass("Click On Priority Icon");
		click(Prioritybtn, WaitStrategy.CLICKABLE, "Priority Icon");
	}
	
	
	public void clickSendbtn()
	{
		//Sendbtn.click();
		//ExtentManager.getExtentTest().pass("Click Send button");
		click(Sendbtn, WaitStrategy.CLICKABLE, "Send button");
	}
	
	
	public void clickToInboxEnable() throws InterruptedException
	{
		//InboxEnable.click();
		//ExtentManager.getExtentTest().pass("Click To Enable the Inbox");
		click(InboxEnable, WaitStrategy.CLICKABLE, "Enable the Inbox");
		Thread.sleep(2000);
	}
	
	
	public void clickOnTaskTitle()
	{
		//ClickTaskTitle.click();
		click(ClickTaskTitle, WaitStrategy.CLICKABLE, "Task Title");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ExtentManager.getExtentTest().pass("Click On Task Title");
	}
	
	
	public void clickSubTask()
	{
		//SubTaskOpen.click();
		//ExtentManager.getExtentTest().pass("Click on Sub-Task");
		click(SubTaskOpen, WaitStrategy.CLICKABLE, "Sub-Task");
	}
	
	
	public void enterTaskDescription(String Description) throws InterruptedException
	{
		TaskDescription.click();
		//sendKeys(TaskDescription, Description, WaitStrategy.PRESENCE, "Enter Task Description");
		Actions actions = new Actions(driver);
		actions.sendKeys(Description).perform();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		ExtentManager.getExtentTest().pass("Enter Task Description");
	}
	
	
	public void enterPriority(String priority)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(TaskTitle).sendKeys(Keys.END).sendKeys(priority).build().perform();
		ExtentManager.getExtentTest().pass("Enter Priority");

	}
	
	
	public void enterHashTag(String HashTag)
	{
		//HashTagbtn.click();
		click(HashTagbtn, WaitStrategy.CLICKABLE, "Enter Hash Tag");
		Actions actions = new Actions(driver);
		actions.moveToElement(TaskTitle).sendKeys(Keys.END).sendKeys(HashTag).build().perform();
		//ExtentManager.getExtentTest().pass("Enter Hash Tag");

	}
	
	public void clickDoNotSavePwd()
	{
	    if (Nothanksbtn.isDisplayed()) 
	     //   Nothanksbtn.click();
	    click(Nothanksbtn, WaitStrategy.CLICKABLE, "Do Not Save Password");
	     //else 
	    	//System.out.println("Skipping the click action.");
	    //ExtentManager.getExtentTest().pass("Click Do Not Save Password");
	}
	
	
	public void verifyInboxTitle(String Title1)
	{
		System.out.println(InboxTitle.getText());
		Assert.assertEquals(InboxTitle.getText(), Title1);
		ExtentManager.getExtentTest().pass("Verify Inbox Title");
	}
	
	
	public void verifyTaskOfTheTitle(String Title)
	{
		Assert.assertEquals(TaskOfTheTitle.getText(), Title);
		ExtentManager.getExtentTest().pass("Verify Task Of The Title");
	}
	
	
	public void verifyCalendarDate(String Date)
	{
		Assert.assertEquals(CalendarDate.getText(), Date);
		ExtentManager.getExtentTest().pass("Verify Calendar Date");
	}
	
	
	public void verifyPriorityIcon()
	{
		Assert.assertTrue(PriorityIcon.isDisplayed());
		ExtentManager.getExtentTest().pass("Verify Priority Icon");
	}
	
	
	public void clickMoreOptions()
	{
		//MoreOptions.click();
		//ExtentManager.getExtentTest().pass("Click More Options");
		click(MoreOptions, WaitStrategy.CLICKABLE, "More Options");
	}
	
	
	public void clickPhotobtn()
	{
		//File file = new File("./TestImg.png");
		//System.out.println(file.getAbsolutePath());
		//Photobtn.sendKeys(file.getAbsolutePath());
		//Photobtn.click();
		//ExtentManager.getExtentTest().pass("Click Photo button");
		click(Photobtn, WaitStrategy.CLICKABLE, "Photo button");
			
	}
	
	
	public void clickStoragePermissionNext()
	{
		if(StoragePermissionNext.isDisplayed())
		//StoragePermissionNext.click();
		click(StoragePermissionNext, WaitStrategy.CLICKABLE, "Storage Permission Next");
		//ExtentManager.getExtentTest().pass("Click Storage Permission Next");
	}
	
	
	public void clickAccessPhotosAllow()
	{
		if(AccessPhotosAllow.isDisplayed())
		//AccessPhotosAllow.click();
		click(AccessPhotosAllow, WaitStrategy.CLICKABLE, "Access Photos Allow");
		//ExtentManager.getExtentTest().pass("Click Access Photos Allow");
	}
	
	
	public void clickMainMenu()
	{
		//if(MainMenu.isDisplayed())
		//MainMenu.click();
		click(MainMenu, WaitStrategy.CLICKABLE, "Main Menu");
		//ExtentManager.getExtentTest().pass("Click Main Menu");
	}
	
	
	public void clickDownloads()
	{
		//if(Downloads.isDisplayed())
		Downloads.click();
		//click(Downloads, WaitStrategy.CLICKABLE, "Downloads");
		ExtentManager.getExtentTest().pass("Click Downloads");
	}
	
	
	public void selectImagesInDownloads()
	{
		ImagesInDownloads.click();
		ExtentManager.getExtentTest().pass("Select Images In Downloads");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickSelectbtn()
	{
		//Selectbtn.click();
		//ExtentManager.getExtentTest().pass("Click Select button");
		click(Selectbtn, WaitStrategy.CLICKABLE, "Select button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}


