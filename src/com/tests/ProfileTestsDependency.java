package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTestsDependency {
	
	@Test (groups="initGroup")
	public void initMethod()
	{
		System.out.println("A");
		Assert.assertTrue(false);
	}
	
	@Test (groups="initGroup")
	public void init2()
	{
		System.out.println("B");
		Assert.assertTrue(false);
	}

	
	@Test (groups={"Regression"}, dependsOnMethods={"initMethod"}, alwaysRun=true)
	public void testDependency1(){
		System.out.println("1");
	}

	@Test (groups={"Regression"}, dependsOnGroups={"initGroup"}, alwaysRun=true)
	public void testDependency2(){
		System.out.println("2");
	}
	
	@Test (groups={"Regression"})
	public void testDependency3(){
		System.out.println("3");
	}

}
