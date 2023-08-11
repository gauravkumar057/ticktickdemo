package org.gauravdemo.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;

public class AndroidAcions {
	
	AndroidDriver driver;
	
	/**
	 * Constructor for the AndroidActions class.
	 * Initializes the AndroidDriver instance.
	 *
	 * @param driver The AndroidDriver instance used for performing actions on Android devices.
	 */
	public AndroidAcions(AndroidDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * Performs a long press action on the given WebElement.
	 *
	 * @param ele The WebElement on which the long press action should be performed.
	 */
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	
	/**
	 * Scrolls to the end of the content by performing scroll gestures repeatedly until there is no more content to scroll.
	 */
//	public void scrollToEndAction()
//	{
//		boolean canScrollMore;
//		do
//		{
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 3.0));
//		}while(canScrollMore);
//	}
	
	/**
	 * Scrolls to the specified text within the content by using the UiScrollable class and UiSelector in Appium.
	 *
	 * @param text The text to scroll into view.
	 */
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	/**
	 * Performs a swipe gesture on the given WebElement in the specified direction.
	 *
	 * @param ele       The WebElement on which the swipe action should be performed.
	 * @param direction The direction of the swipe action (e.g., "up", "down", "left", "right").
	 */
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), // ID of the element on which to perform the swipe
			    "direction", direction, // Direction of the swipe action
			    "percent", 0.75 // The percentage of the swipe gesture to perform
			));
	}
	
	/**
	 * Extracts the price value from a string and returns it as a double.
	 *
	 * @param amount The string containing the price value.
	 * @return The price value extracted from the string as a double.
	 */
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}	
	
}
