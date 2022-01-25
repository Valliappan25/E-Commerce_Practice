package com.testing.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver openBrowser(String browserType)
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().cachePath("Driver").setup();
	        return new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().cachePath("Driver").setup();     
			return new FirefoxDriver();
		}
	}
}
	
	
