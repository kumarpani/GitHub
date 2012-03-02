package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
	
	@Test (groups = {"Smoke"})
	public void verifyValidLogin()
	{
		landingPage.navigateToLoginPage();
		loginPage.performLogin(data.getProperty("email"), data.getProperty("password"));
		Assert.assertTrue(driver.findElementByLinkText(data.getProperty("id")).isDisplayed());
	}

	@Test (groups={"Regression"})
	public void verifyInvalidUser()
	{	
		landingPage.navigateToLoginPage();
		loginPage.performLogin("a@a.com", "password1");
		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect login or password.");
	}

	
}

