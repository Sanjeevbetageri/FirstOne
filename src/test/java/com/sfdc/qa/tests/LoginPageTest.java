package com.sfdc.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.HomePage;
import com.sfdc.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage home;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void TestTitle()
	{
		String title = loginPage.ValidateTitle();
		Assert.assertEquals(title, "FB");
	}
	
	@Test(priority=2)
	public void ImgChk()
	{
		boolean f=loginPage.ValidateImg();
		Assert.assertTrue(f);
	}
	
	@Test(priority=3)
	public void logiTest()
	{
		home=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
