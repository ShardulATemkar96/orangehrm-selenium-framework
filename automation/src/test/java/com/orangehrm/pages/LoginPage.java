package com.orangehrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.ElementActions;

public class LoginPage  {

	private WebDriver driver;
	private ElementActions actions;
	
	//Locators
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By profileHeader = By.xpath("//h6[contains(text(), 'Dashboard')]");
	private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		this.actions = new ElementActions(driver);
    }
	
	public void login(String username, String password) {
		actions.type(usernameField, username);
		actions.type(passwordField, password);
		actions.click(loginBtn);
	}
	
	public String getErrorMessage() {
		if(actions.isDisplayed(errorMessage)) {
			return actions.getText(errorMessage);
		}
		return null;
	}
	
	public boolean isDashboardVisible() {
		return actions.isDisplayed(profileHeader);
	}
	
	public boolean isRequiredFieldErrorVisible() {
	 By requiredError = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
	 return actions.isDisplayed(requiredError);
	}

	//	public void enterUsername(String user) {
//		log.info("Entering userneame : "+ username);
//		type(username, user);
//	}
//	
//	public void enterPassword(String pass) {
//		 log.info("Entering password");
//		type(password, pass);
//	}
//	
//	public void clickLogin() {
//		log.info("Clicking login button");
//		click(loginBtn);
//	}
//	
//	public String getErrorMessage() {
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		 try {
//			 WebElement invalid = waitForVisibility(errorMessage);
//			 return invalid.getText().trim();
//		 }catch (Exception e) {}
//		 
//		 try {
//			 WebElement required = waitForVisibility(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]"));
//			 return required.getText().trim();
//		 }catch (Exception e) {
//			 return null;
//		 }
//
//}
//	
//	public boolean isDashboardVisible() {
//		return isVisible(profileHeader);
//		//		try {
////	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////	        wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader));
////	        return driver.findElement(profileHeader).isDisplayed();
////	    } catch (Exception e) {
////	        return false;
////	    }
//	}
//	
//	 public void login(String user, String pass) {
//	        log.info("Performing login with user: " + user);
//	        type(username, user);
//	        type(password, pass);
//	        click(loginBtn);
//
//	    }
}
