package com.orangehrm.flows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.Employee;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.MenuPage;

public class EmployeeFlows {
	
	private MenuPage menu;
	private AddEmployeePages addEmployee;
	private EmployeeListPage employeeList;
	
	public EmployeeFlows(WebDriver driver) {
	
		this.menu = new MenuPage(driver);
		this.addEmployee = new AddEmployeePages(driver);
		this.employeeList = new EmployeeListPage(driver);
	}

	public boolean createEmployee(Employee employee) {
		menu.clickPIM();
		menu.clickAddEmployee();
		
		addEmployee.addEmployee(
		        employee.firstName(),
		        employee.middleName(),
		        employee.lastName(),
		        employee.employeeId()
		    );
		return addEmployee.isPersonalHeaderVisible();
	}
	
	public boolean onlyCreateEmployee(Employee employee) {
		menu.clickPIM();
		menu.clickAddEmployee();
		
		addEmployee.onlyAddEmployee(
				employee.firstName(),
				employee.middleName(),
				employee.lastName(),
				employee.employeeId()
				);
		return addEmployee.isPersonalHeaderVisible();

	}
	
	public boolean isEmployeePresent(Employee employee) {
		menu.clickPIM();
		menu.clickEmployeeList();
		employeeList.searchEmployee(employee.firstName());
		return 	employeeList.isEmployeeFound(employee.firstName());
	}
	
	public boolean deleteEmployee(Employee employee) {
		menu.clickPIM();
		menu.clickEmployeeList();
		
		employeeList.searchEmployee(employee.firstName());
				
		return employeeList.deleteEmployee(employee.firstName());
		}
	
}
