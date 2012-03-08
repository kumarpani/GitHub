package com.tests;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.PropertyFileReader;
import com.pages.LandingPage;
import com.pages.LoginPage;


public class BaseTest {
	
	public FirefoxDriver driver;
	public LoginPage loginPage;
	public LandingPage landingPage;
	PropertyFileReader data;
	
	
	@BeforeMethod (groups = {"Smoke", "Regression"})
	public void beforeMethod(Method method)
	{
		
		System.out.println("Executing Test: "+ method.getDeclaringClass().getName() + "." + method.getName());
		

		FirefoxProfile myProfile = new FirefoxProfile(); 
		myProfile.setPreference("browser.cache.disk.enable", false); 

		driver = new FirefoxDriver(myProfile);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://github.com");
		data = new PropertyFileReader("Data.properties");
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		landingPage = PageFactory.initElements(driver, LandingPage.class);


	}
	
	@AfterMethod (groups = {"Smoke", "Regression"})
	public void afterMethod()
	{
		System.out.println("AFTER TEST");
		driver.quit();
	}



}
