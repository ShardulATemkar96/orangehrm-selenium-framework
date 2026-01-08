package com.orangehrm.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;



public class LoginTest extends BaseTest {
	
	
	
	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData(){
		return new Object[][] {
				{"wrongUser", "admin123"},
				{"Admin","wrongPass"},
				{"wrongUser","wrongPass"},
				{"","admin"},
				{"Admin",""}
		};
	}
	@Test(groups = {"smoke","regression"})
	public void validLoginTest() {
		  log.info("Starting valid login test");
		  
		  LoginPage login = new LoginPage(driver);
		  DashBoardPage dashboard = new DashBoardPage(driver);
		  
		  login.login("Admin","admin123");
		  log.info("Logged in successfully");
		  
		  Assert.assertTrue(dashboard.isDashboardHeaderVisible(), "DashBoard is not visible !");
		  log.info("Valid login test passed");
				
	}
	
	@Test(dataProvider = "invalidLoginData" , groups = {"regression"})
	public void invalidLoginTest(String username, String password) {
		
		log.info("Running invalid login test with: " + username + " / " + password);

		driver.navigate().refresh();
		
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		
		if(username.isEmpty() || password.isEmpty()) {
			Assert.assertTrue(login.isRequiredFieldErrorVisible(),
			"Required feild validation message not shown ");
		}else {
			String error = login.getErrorMessage();
			Assert.assertEquals(error,"Invalid credentials",
					"Invalid credentials message not shown ");
		}
		

	}
}