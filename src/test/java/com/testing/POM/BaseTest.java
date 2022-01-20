package com.testing.POM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.testing.Factory.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeTest
	public void startDriver()
	{
		driver = DriverFactory.openBrowser("chrome");
		driver.get("https://askomdch.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
