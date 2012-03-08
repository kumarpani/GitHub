package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class LoginNegativeTests extends BaseTest{
	
//	@Test (groups={"Regression"})
//	public void verifyInvalidUser()
//	{	
//		landingPage.navigateToLoginPage();
//		loginPage.performLogin("a@a.com", "password1");
//		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect login or password.");
//	}
	
	@DataProvider(name = "InvalidLogins")
	public String[][] invalidLogins(){
		return new String[][] {
				{"", "", "Blank Username and Password"},				
				{"" ,"password1", "Blank Username"},
				{"kumarpani", "", "Blank Password"}
			};
	}

	@Test (dataProvider = "InvalidLogins", groups={"Regression"}, description="This test illustrates data driven test")
	public void verifyInvalidUserDataDrivenTest(String userName, String password, String Scenario)
	{		
		landingPage.navigateToLoginPage();
		loginPage.performLogin(userName, password);
		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect login or password.", 
				String.format("Failed for scnerio: %s", Scenario));
	}
}
