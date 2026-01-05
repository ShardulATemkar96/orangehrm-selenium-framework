package com.orangehrm.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.orangehrm.utils.ConfigReader;

public class DriverFactory {
	
	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static WebDriver driver;
	public static WebDriver initDriver() {

		String browser = ConfigReader.get("browser");
		int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver  = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Invalid broswer in config.properties");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		return driver;
//		Properties prop = ConfigReader.loadConfig();
//		String browserName = prop.getProperty("browser");
//		
//		if (browserName.equalsIgnoreCase("chrome")) {
//			driver.set(new ChromeDriver());
//		}
//		getDriver().manage().window().maximize();
//		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
			
		}
	}

}
