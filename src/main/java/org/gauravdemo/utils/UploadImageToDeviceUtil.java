package org.gauravdemo.utils;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;

public class UploadImageToDeviceUtil {
	
	public static void uploadImage(AndroidDriver driver){

		try {
			driver.pushFile("/storage/emulated/0/Download/image.png", new File("C://Users//Gaurav Kumar//Workspace//TickTickFrameworkDesign//src//test//java//org//gauravdemo//resources//logos//Image.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
