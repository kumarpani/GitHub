package com.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
	
	@Test
	public void changeProfileName()
	{
		landingPage.navigateToLoginPage();
		loginPage.performLogin("kumarpani@gmail.com", "password1");

		driver.findElementById("settings").click();
		
		driver.findElementByXPath("//dl[@data-name='profile_name']//input").clear();
		driver.findElementByXPath("//dl[@data-name='profile_name']//input").sendKeys("Pani Kumar E");
		driver.findElementByLinkText("Account Settings").click();
		driver.findElementByLinkText("Profile").click();
		
		Assert.assertEquals(driver.findElementByXPath("//dl[@data-name='profile_name']//input").getAttribute("value"), "Pani Kumar E");		
	}
	
	@Test
	public void verifyChangeLocation()
	{
		landingPage.navigateToLoginPage();
		loginPage.performLogin("kumarpani@gmail.com", "password1");
		
	}
}
