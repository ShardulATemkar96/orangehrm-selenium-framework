package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.factory.EmployeeDataFactory;
import com.orangehrm.flows.EmployeeFlows;
import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.Employee;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;

public class AddEmployeeTest extends BaseTest {
	 
	 LoginPage login;
	 MenuPage menu;
	 DashBoardPage dashboard ;
	 Employee employee;
	 EmployeeFlows flows;
	 AddEmployeePages addEmployee;
	
	
	@BeforeMethod
	public void setupPages() {
		login = new LoginPage(driver);
		dashboard = new DashBoardPage(driver);
		menu = new MenuPage(driver);
		employee = EmployeeDataFactory.createEmployee();
		flows = new EmployeeFlows(driver);
		addEmployee = new AddEmployeePages(driver);
	}
	
	@Test(groups = {"regression" , "employee"})
	public void addNewEmployeeTest() {
		
		login.login("Admin","admin123");
		
	
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(),
				"Dashboard is not visible after login ");
	
	    flows.onlyCreateEmployee(employee);
		Assert.assertTrue(addEmployee.isPersonalHeaderVisible(),
				"Employee was not added successfully");
	}

}
