package com.testing.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal();
	
	private void setDriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	protected WebDriver getDriver()
	{
		return this.driver.get();
	}
	
	@Parameters("browser")
	@BeforeTest
	public void startDriver(String browser)
	{
		 browser = System.getProperty("browser",browser);
		
		switch(browser.toLowerCase()){
		case "chrome":
			WebDriverManager.chromedriver().cachePath("Driver").setup();
	       setDriver(new ChromeDriver());
	       break;
	       
		case "firefox":
			WebDriverManager.firefoxdriver().cachePath("Driver").setup();
		       setDriver(new FirefoxDriver());
		    break;
		    
		default:
			throw new IllegalArgumentException("Invalid Browser "+ browser);
		}
		
		System.out.println("Current Thread " + Thread.currentThread().getId());
		System.out.println("Driver " + getDriver());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}
	
	public void loadURL()
	{
		getDriver().get("https://askomdch.com");
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(500);
		System.out.println("Current Thread " + Thread.currentThread().getId());
		System.out.println("Driver " + getDriver());
		getDriver().quit();
		
		
	}
}
