package com.pages;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	FirefoxDriver driver;
	public LoginPage(FirefoxDriver driver) {
		this.driver=driver;
	}
	public void performLogin(String userId, String password) {
		driver.findElementById("login_field").sendKeys(userId);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByName("commit").click();
	}
	
	public String getErrorMessage() {
		return driver.findElementByClassName("error_box").getText();
	}
}
