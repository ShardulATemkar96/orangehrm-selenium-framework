package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {
	
	public static String takeScreenShot(WebDriver driver, String screenshotName) // --> the parameters here explain that we need to pass the driver and the name of the screenshot
	{
	
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = System.getProperty("user.dir") + "/reports/screenshots/" + 
				 	 	 	screenshotName + "_" + timestamp + ".png";
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		
		try {
			FileHandler.copy(src,  dest);;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
