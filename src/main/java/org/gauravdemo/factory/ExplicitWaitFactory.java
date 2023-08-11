package org.gauravdemo.factory;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.function.Function;

import org.gauravdemo.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
    }
    /**
     * Performs an explicit wait based on the provided wait strategy.
     *
     * @param waitStrategy the wait strategy to be used
     * @param element the element to be waited for
     * @param driver the Android driver
     * @return the waited WebElement
     */
	public static WebElement performExplicitWait(final WaitStrategy waitStrategy, final WebElement element, final AndroidDriver driver) {
        Wait<AndroidDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30));

        return wait.until(new Function<AndroidDriver, WebElement>() {
            @Override
            public WebElement apply(AndroidDriver driver) {
                switch (waitStrategy) {
                    case CLICKABLE:
                        return ExpectedConditions.elementToBeClickable(element).apply(driver);
                    case VISIBLE:
                        return ExpectedConditions.visibilityOf(element).apply(driver);
                    case PRESENCE:
                        return ExpectedConditions.presenceOfElementLocated((By) element).apply(driver);
                    case NONE:
                        return element;
                }
                return null;
            }
        });
    }

    // Other utility methods or constants can be added here as needed
	
    public static WebElement performExplicitWaitWait(WaitStrategy waitstrategy, By by) {
        return null;
    }
}
