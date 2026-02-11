package com.orangehrm.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.ElementActions;

public class TableComponent {

	private WebDriver driver;
	private ElementActions actions;
	private By rowsLocator;
	
	public TableComponent(WebDriver driver, By rowsLocator) {
		super();
		this.driver = driver;
		this.actions = new ElementActions(driver);
		this.rowsLocator = rowsLocator;
	}

	public WebElement findRowByCellText(int columnIndex, String text) {
		
		List<WebElement> rows = actions.getElements(rowsLocator);
		
		for (WebElement row : rows) {
			
			WebElement cell = row.findElement(By.xpath(".//div[@role='cell']["+ columnIndex + "]"));
			
			if(cell.getText().contains(text)) {
			return row;
			}
		}
		return null;
	}
	
	public boolean isRowPresent(int columnIndex, String text) {
		return findRowByCellText(columnIndex, text) != null;
	}
	
	public boolean deleteRowByCellText(int columnIndex, String text,By deleteButtonLocator,By confirmLocator, By toastLocator) {
		
		WebElement row = findRowByCellText(columnIndex, text);
		
		if(row == null) {
			return false;
		}
		
		row.findElement(deleteButtonLocator).click();
		actions.click(confirmLocator);
		
		return actions.isDisplayed(toastLocator);
	}
	
}
