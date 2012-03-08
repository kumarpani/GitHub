package com.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestNGMethod;

import java.io.File;
import java.io.IOException;


public class LoginTests extends BaseTest {
	
	@Test (groups = {"Smoke", "Regression"}, description="Capture Screen shot of assertion failure")
	public void verifyValidLoginCaptureScreenShot()
	{
		landingPage.navigateToLoginPage();
		loginPage.performLogin(data.getProperty("email"), data.getProperty("password"));
				
		try{			
			Assert.assertEquals(driver.findElementByClassName("name").getText(), "kumarpani");
		}
		catch(Exception e)
		{
			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("a.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);			
		}
	}
}

