package org.gauravdemo.utils;

import java.util.Random;
import io.appium.java_client.android.AndroidDriver;

public class GenerateRandomEmail {
	
	AndroidDriver driver;
	
	public GenerateRandomEmail(AndroidDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * Generates a random alphanumeric string of a fixed length.
	 *
	 * @return The randomly generated alphanumeric string.
	 */
	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
}
