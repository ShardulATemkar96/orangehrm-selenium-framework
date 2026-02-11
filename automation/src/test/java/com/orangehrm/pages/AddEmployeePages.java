package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.ElementActions;

public class AddEmployeePages {
	
	private WebDriver driver;
	private ElementActions actions;
	
	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By employeeId =By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
	private By saveBtn = By.xpath("//button[@type=\"submit\"]");
	private By personalDetailsHeader =By.xpath("//h6[text()='Personal Details']");

	public AddEmployeePages(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
	}
	
	public void enterFirstName(String fname) {

		actions.type(firstName, fname);
	}
	
	public void enterMiddleName(String mname) {

		actions.type(middleName, mname);
		}
	
	public void enterLastName(String lname) {
		
		actions.type(lastName, lname);
		}
	
	public void enterEmpoyeeId(String empId) {

		actions.type(employeeId, empId);
	}
	
	public void clickSave() {
	
		actions.click(saveBtn);
	}

	
	public boolean isPersonalHeaderVisible() {
		
		return actions.isDisplayed(personalDetailsHeader);
	}
	
	
	
	public void addEmployee(String fname, String mname, String lname, String empId) {
		
		enterFirstName(fname);
		enterMiddleName(mname);
		enterLastName(lname);
		enterEmpoyeeId(empId);
		clickSave();
		clickSave();
		System.out.println("New Employee added");
	}
	public void onlyAddEmployee(String fname, String mname, String lname, String empId) {
		
		enterFirstName(fname);
		enterMiddleName(mname);
		enterLastName(lname);
		enterEmpoyeeId(empId);
		clickSave();
		System.out.println("New Employee added");
	}

}
