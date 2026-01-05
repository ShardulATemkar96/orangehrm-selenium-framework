package com.orangehrm.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utils.ConfigReader;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	protected Logger log = LogManager.getLogger(this.getClass());

	
	@BeforeClass
	public void setup() {

		driver = DriverFactory.initDriver();
		String url = ConfigReader.get("url");
		log.info("Opening URL: "+ url);
		driver.get(url);

		
		Reporter.getCurrentTestResult().getTestContext().setAttribute("WebDriver", driver);
		log.info("Browser launched and navigated to OrangeHRM login page");
	}
	
//	@AfterClass
//	public void tearDown() {
//		log.info("Closing browser");
//		DriverFactory.quitDriver();
//		}
	}

