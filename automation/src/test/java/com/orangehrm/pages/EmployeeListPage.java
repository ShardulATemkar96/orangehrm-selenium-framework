package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.ElementActions;

public class EmployeeListPage  {

	private WebDriver driver;
	private ElementActions actions;
	
	private By employeeNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By searchBtn = By.xpath("//button[@type='submit']");
	private By employeeTableRows = By.xpath("//div[contains(@class,'orangehrm-container')]/div");

	private By deleteIcons = By.xpath("//button[i[contains(@class,'bi-trash')]]");
	private By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
	private By successToast = By.xpath("//div[@id='oxd-toaster_1']");
	private By empListHeader = By.xpath("//h5[text() = 'Employee Information']");
	private By resultEmployeeName = By.xpath("//div[@role='row']//div[@role='cell'][2]");
	
	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
	}
	
	public void searchEmployee(String employeeName) {
		actions.isDisplayed(employeeNameField);
		actions.type(employeeNameField, employeeName);
		actions.click(searchBtn);
	
	}
	
	public boolean isEmployeeFound(String employeeName) {
		List<WebElement> rows = driver.findElements(employeeTableRows);
		
		for(WebElement row : rows) {
			if (row.getText().contains(employeeName)) {
				return true;
			}
		}
		return false;
	}

	public void deleteEmpoyee(String employeeName) {
		
		searchEmployee(employeeName);
		
		List<WebElement> rows = driver.findElements(employeeTableRows);
		
		for(WebElement row :rows) {
			if (row.getText().contains(employeeName)) {
				row.findElement(deleteIcons).click();
				break;
			}
		}
		actions.click(confirmDeleteBtn);
	}
	
	public boolean isDeleteSuccess() {
		return actions.isDisplayed(successToast);
	}
	
	public boolean isEmployeeListHeaderVisible() {
		return actions.isDisplayed(empListHeader);
	}
	public String getFirstResultName() {
		return actions.getText(resultEmployeeName);
	}
}
