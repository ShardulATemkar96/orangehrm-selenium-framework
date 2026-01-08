package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.ElementActions;

public class MenuPage  {
	 private WebDriver driver;
	    private ElementActions actions;
	
	private By pimMenu = By.xpath("//span[text()='PIM']");
    private By dashboardMenu = By.xpath("//span[text()='Dashboard']");
    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By timeMenu = By.xpath("//span[text()='Time']");
    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
    
    // submenus
    private By employeeList = By.xpath("//a[normalize-space()='Employee List']");
    private By addEmployee =By.xpath("//a[normalize-space()='Add Employee']");
    
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
	}

	public void clickDashboard(){
		actions.click(dashboardMenu);
	}
	public void clickAdmin(){
		actions.click(adminMenu);
	}
	public void clickPIM(){
		actions.click(pimMenu);
	}
	public void clickLeave(){
		actions.click(leaveMenu);
	}
	public void clickTime(){
		actions.click(timeMenu);
	}
	public void clickRecruitment(){
		actions.click(recruitmentMenu);
	}
	
	//Submenus
	public void clickEmployeeList(){
		actions.click(employeeList);
	}
	public void clickAddEmployee(){
		actions.click(addEmployee);
	}
}
