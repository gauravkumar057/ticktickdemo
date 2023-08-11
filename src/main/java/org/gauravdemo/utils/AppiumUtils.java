package org.gauravdemo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public abstract class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		// System.getProperty("user.dir")+"\\src\\test\\java\\org\\gauravdemo\\TestData\\tickTick.json"
		// convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		// Set up Appium service
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//Gaurav Kumar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.usingDriverExecutable(new File("C://Program Files//nodejs//node.exe"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	

}
