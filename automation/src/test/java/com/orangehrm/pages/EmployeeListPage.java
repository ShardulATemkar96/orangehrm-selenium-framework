package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.components.TableComponent;
import com.orangehrm.utils.ElementActions;

public class EmployeeListPage  {

	private WebDriver driver;
	private ElementActions actions;
	private TableComponent table;
	
	private By employeeNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By searchBtn = By.xpath("//button[@type='submit']");
	private By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
	private By successToast = By.xpath("//div[@id='oxd-toaster_1']");
	private By empListHeader = By.xpath("//h5[text() = 'Employee Information']");
	private By employeeFirstName = By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][3]");
	private By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");	
	
	
	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
		this.table = new TableComponent(driver, tableRows);
	}
	
	public void searchEmployee(String employeeName) {
		actions.type(employeeNameField, employeeName);
		actions.click(searchBtn);
		actions.isDisplayed(employeeFirstName);
	}
	
	public boolean isEmployeeFound(String firstName) {
		return table.isRowPresent(3, firstName);
		
//		List<WebElement> rows = actions.getElements(tableRows);
//		
//		if (rows.isEmpty()) {
//			return false;
//		}
//		
//		for (WebElement row : rows) {
//			
//			WebElement namecell =  row.findElement(By.xpath(".//div[@role='cell'][3]"));
//			
//			if (namecell.getText().contains(firstName)) {
//				return true;
//				
//			}
//		}
//		return false;
//		List<WebElement> names = actions.getElements(employeeFirstName);
//		if(names.isEmpty()) {
//			return false;
//	        }
//		for(WebElement name : names) {
//			if(name.getText().contains(firstName)) {
//				return true;
//			}
//		}
//		return false;
	}
	
	public boolean deleteEmployee(String firstName) {

	By deleteBtn = By.xpath(".//button[i[contains(@class,'bi-trash')]]");
	
	return table.deleteRowByCellText(
			3, 
			firstName, 
			deleteBtn, 
			confirmDeleteBtn, 
			successToast);
		
//		List<WebElement> rows = actions.getElements(tableRows);
//		
//		for (WebElement row : rows) {
//			WebElement namecell =  row.findElement(By.xpath(".//div[@role='cell'][3]"));
//			
//			if(namecell.getText().contains(firstName)) {
//				WebElement deleteBtn = row.findElement(By.xpath(".//button[i[contains(@class,'bi-trash')]]"));
//				
//				deleteBtn.click();
//				actions.click(confirmDeleteBtn);
//				
//				return actions.isDisplayed(successToast);
//			}
//		}
//		return false;
//		actions.click(deleteIcons);
//		actions.click(confirmDeleteBtn);
	}

	
	public boolean isDeleteSuccess() {
		return actions.isDisplayed(successToast);
	}
	
	public boolean isEmployeeListHeaderVisible() {
		return actions.isDisplayed(empListHeader);
	}
	public String getFirstResultName() {
		return actions.getText(employeeFirstName);
	}
}
