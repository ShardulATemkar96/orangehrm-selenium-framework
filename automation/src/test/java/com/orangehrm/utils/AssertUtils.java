package com.orangehrm.utils;

import org.testng.asserts.SoftAssert;

public class AssertUtils {
	
	private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();
	
	public static void initSoftAssert() {
		softAssert.set(new SoftAssert());  
	}
	
	public static SoftAssert getSoftAssert() {
		return softAssert.get();
	}
	
	public static void assertAll() {
		softAssert.get().assertAll();
	}
	

}
