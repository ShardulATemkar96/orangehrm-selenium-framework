package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class AddEmployeeTest extends BaseTest {
	
	@Test
	public void addNewEmployeeTest() {
		LoginPage login = new LoginPage(driver);
		login.login("Admin","admin123");
		
		DashBoardPage dashboard = new DashBoardPage(driver);
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(),
				"Dashboard is not visible after login ");
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		AddEmployeePages addEmp = new AddEmployeePages(driver);
		
		addEmp.addEmployee("Sam", "S", "Wick", "007");
		
		Assert.assertTrue(addEmp.isPersonalHeaderVisible(),
				"Personal Details page did not appear after saving ");
		
		log.info("Add Employee Test passed Sucessfully ");
		
	}

}
