package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.LandingPage;
import com.pages.LoginPage;

public class BaseTest {
	
	public FirefoxDriver driver;
	LoginPage loginPage;
	LandingPage landingPage;
	PropertyFileReader data;
	
	
	@BeforeMethod (groups = {"Smoke", "Regression"})
	public void beforeMethod()
	{
		System.out.println("BEFORE TEST");

		FirefoxProfile myProfile = new FirefoxProfile(); 
		myProfile.setPreference("browser.cache.disk.enable", false); 

		driver = new FirefoxDriver(myProfile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);

		driver.get("http://github.com");
		
		data = new PropertyFileReader("Data.properties");
	}
	
	@AfterMethod (groups = {"Smoke", "Regression"})
	public void afterMethod()
	{
		System.out.println("AFTER TEST");
		driver.quit();
	}



}
