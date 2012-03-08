package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	FirefoxDriver driver;
		
	@FindBy(id="login_field")		private WebElement loginField;
	@FindBy(id="password")			private WebElement passwordField;
	@FindBy(name="commit")			private WebElement submit;
	@FindBy(className="error_box")	private WebElement errorField;
	
	
	public void performLogin(String userId, String password) {
		loginField.sendKeys(userId);
		passwordField.sendKeys(password);
		submit.click();
	}
	
	public String getErrorMessage() {
		return errorField.getText();
	}
}
