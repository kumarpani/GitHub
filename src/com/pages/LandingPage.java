package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;


public class LandingPage {
	
	FirefoxDriver driver;
	
	@FindBy(linkText="Login")	private WebElement loginLink;

	public void navigateToLoginPage() { 
		loginLink.click();
	}
}
