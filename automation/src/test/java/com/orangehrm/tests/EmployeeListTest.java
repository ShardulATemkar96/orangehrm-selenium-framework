package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;

public class EmployeeListTest extends BaseTest {

	
	DashBoardPage dashboard;
	
	
	
	@BeforeClass
	public void setupPages() {
		
		dashboard = new DashBoardPage(driver);
		
		
	}
	
	@Test
	public void searchAndDeleteEmployeeTest() {
		
		
		log.info("Starting Delete Employee Test");
		LoginPage login = new LoginPage(driver);
		login.login("Admin","admin123");
		login.clickLogin();
		
		Assert.assertTrue(login.isDashboardVisible(), "Dashboard not visible after login ");
		
		MenuPage menu = new MenuPage(driver);
		menu.clickPIM();
		menu.clickEmployeeList();
		
		EmployeeListPage empList  = new EmployeeListPage(driver);
		
		String employeeName = "Sam Wick";
		
		empList.searchEmployee(employeeName);
		Assert.assertTrue(empList.isEmployeeFound(employeeName), "Employee not found in list ");
		
		empList.deleteEmpoyee(employeeName);
		
		Assert.assertTrue(empList.isDeleteSuccess(), "Delete success toast not visible ");
		
		log.info("--Employee List Tets Completed--");
	}
	
	
}
