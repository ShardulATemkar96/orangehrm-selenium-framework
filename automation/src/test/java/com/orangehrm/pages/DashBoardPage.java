package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.ElementActions;

public class DashBoardPage {

	  private WebDriver driver;
	  private ElementActions actions;
	  
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By quickLaunchPanel = By.xpath("//p[normalize-space()='Quick Launch'][1]"); // FIXED LOCATOR
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    public DashBoardPage(WebDriver driver) {
    	 this.driver = driver;
         this.actions = new ElementActions(driver);
    }

    public boolean isDashboardHeaderVisible() {
    	return actions.isDisplayed(dashboardHeader);
    }

    public void goToEmployeeList() {
    	actions.click(pimMenu);
    	actions.click(employeeListMenu);
    }
    
    public boolean isQuickLaunchPanelVisible() {
    	return actions.isDisplayed(quickLaunchPanel);
    }
}

