package com.sfdc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sfdc.qa.utilities.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
		
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("/Users/Sanjeev/eclipse-workspace/Testing/src/main/java/com/sfdc/qa/config/config.properties");
		prop.load(ip);
		
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C://Sanjeev//chromedriver_win32 (1)//chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
