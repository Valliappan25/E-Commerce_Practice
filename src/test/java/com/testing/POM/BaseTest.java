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
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}
	
	public void loadURL()
	{
		driver.get("https://askomdch.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(500);
	}
}
