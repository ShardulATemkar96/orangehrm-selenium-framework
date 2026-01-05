package com.orangehrm.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	
static {
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		prop.load(fis);
		System.out.println("==== Config Loaded Successfully ====");
		
	}catch (Exception e) {
		System.out.println("==== FAILED To Load Config File ====");
		e.printStackTrace();
	}
}

public static String get(String key) {
	if(prop== null) {
		throw new RuntimeException("==== FAILED To Load Config File ====");
	}
	return prop.getProperty(key);
}
}
