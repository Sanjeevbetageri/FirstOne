package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(xpath="//*[@value='Log In']")
	WebElement LogInBtn;
	
	@FindBy(xpath="//*[@class='fb_logo img sp_QWp0VwOicFX sx_d3b7ee']")
	WebElement Img;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String ValidateTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateImg()
	{
		return Img.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		email.sendKeys(un);
		pass.sendKeys(pwd);
		LogInBtn.click();
		
		return new HomePage();
	}
}
