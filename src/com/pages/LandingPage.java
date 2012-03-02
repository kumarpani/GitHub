package com.pages;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LandingPage {
	
	FirefoxDriver driver;
	
	public LandingPage(FirefoxDriver driver){
		this.driver=driver;
	}

	public void navigateToLoginPage() {
		driver.findElementByLinkText("Login").click();
	}

}
