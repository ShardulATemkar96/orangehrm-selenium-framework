package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.base.BasePage;

public class AddEmployeePages extends BasePage {
	
	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By employeeId =By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
	private By saveBtn = By.xpath("//button[@type='submit']");
	private By personalDetailsHeader =By.xpath("//h6[text()='Personal Details']");
	
	public AddEmployeePages(WebDriver driver) {
		super(driver);
	}
	
	public void enterFirstName(String fname) {
		log.info("Entering first name: " + fname);
		type(firstName, fname);
	}
	
	public void enterMiddleName(String mname) {
		log.info("Entering middle name: " + mname);
		type(middleName, mname);
		}
	
	public void enterLastName(String lname) {
		log.info("Entering last name: " + lname);
		type(lastName, lname);
		}
	
	public void enterEmpoyeeId(String empId) {
		log.info("Entering employee ID : " + empId);
		type(employeeId, empId);
	}
	
	public void clickSave() {
		log.info("Clicking Save button");
		click(saveBtn);
	}
	
	public boolean isPersonalHeaderVisible() {
		log.info("Checking if Personal Details header is visible");
		return isVisible(personalDetailsHeader);
	}
	
	public void addEmployee(String fname, String mname, String lname, String empId) {
		log.info("Adding new employee: " + fname + " " + lname);
		enterFirstName(fname);
		enterMiddleName(mname);
		enterLastName(lname);
		enterEmpoyeeId(empId);
		clickSave();
	}

}
