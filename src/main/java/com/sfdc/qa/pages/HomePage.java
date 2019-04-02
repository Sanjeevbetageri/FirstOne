package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//*[@title='Profile']")
	WebElement DP;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean DisplayDP()
	{
		return DP.isDisplayed();
	}
	
}
