package com.orangehrm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		if (extent == null) {
			
		}
		return extent;
	}
	
}
