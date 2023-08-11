package org.gauravdemo.pageObjects.android;

import org.gauravdemo.Reports.ExtentLogger;
import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.WebElement;


public class BasePage {
	
	protected void click(WebElement element, WaitStrategy waitstrategy, String elementName) {
	    element.click();
	    ExtentLogger.pass(elementName + " is clicked successfully");
	}
	
	protected void sendKeys(WebElement element, String value, WaitStrategy waitstrategy, String elementName) {
	    element.sendKeys(value);
	    ExtentLogger.pass(value + " is entered successfully in " + elementName);
	}
	
	
	protected String getText(WebElement element, WaitStrategy waitstrategy) {
	    String text = element.getText();
	    ExtentLogger.pass("'" + text + "' is displayed successfully");
	    return text;
	}
	
	/*protected void verifyEnable(WebElement element, WaitStrategy waitstrategy, String elementName) {
	    element.isEnabled();
	    ExtentLogger.pass("Verify" + elementName + " is enable");
	}*/

}
 