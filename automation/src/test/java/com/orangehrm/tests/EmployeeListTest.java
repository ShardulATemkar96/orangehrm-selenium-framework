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
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;


public class EmployeeListTest extends BaseTest {

	
	LoginPage login;
	MenuPage menu;
	EmployeeListPage empList;
	DashBoardPage dashboard;
	AddEmployeePages addEmployee;
	Employee employee;
	EmployeeFlows employeeFlows;
	
	  @BeforeMethod(alwaysRun = true)
	    public void setupPages() {
	        login = new LoginPage(driver);
	        menu = new MenuPage(driver);
	        empList = new EmployeeListPage(driver);
	        dashboard = new DashBoardPage(driver);
	        addEmployee = new AddEmployeePages(driver);
	        employee = EmployeeDataFactory.createEmployee();
	        employeeFlows = new EmployeeFlows(driver);
	  }
	
	@Test(groups = {"regression"})
	public void searchAndDeleteEmployeeTest() {
		
		
		log.info("Starting Delete Employee Test");
		
		login.login("Admin","admin123");
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(),
				"Dashboard did not load properly");
	
		employeeFlows.createEmployee(employee);
		
		 employeeFlows.deleteEmployee(employee);
		

		log.info("--Employee List Tets Completed--");
	}
}
