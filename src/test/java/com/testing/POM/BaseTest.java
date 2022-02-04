package com.testing.POM;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.testing.Utilities.ConfigLoader;
import com.testing.Utilities.CookieUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookies;

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
	@BeforeMethod
	public void startDriver(String browser)
	{
		 browser = System.getProperty("browser",browser);
		
		switch(browser.toLowerCase()){
		case "chrome":
			WebDriverManager.chromedriver().cachePath("Driver").setup();
	       setDriver(new ChromeDriver());
	       break;
	       
		case "edge":
			WebDriverManager.edgedriver().cachePath("Driver").setup();
		       setDriver(new EdgeDriver());
		    break;
		    
		default:
			throw new IllegalArgumentException("Invalid Browser "+ browser);
		}
		
		System.out.println("Current Thread " + Thread.currentThread().getId());
		System.out.println("Driver " + getDriver());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}
	
	public void loadURL(String urlPath) throws IOException
	{
		getDriver().get(ConfigLoader.getInstance().getURL()+urlPath);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
	}
	
	public void injectCookiesToBrowser(Cookies cookies)
	{
		CookieUtils cookieUtils = new CookieUtils();
		List<Cookie> seleniumCookies = cookieUtils.convertRestAssuredToSeleniumCookies(cookies);
		for(Cookie cookie : seleniumCookies)
		{
			getDriver().manage().addCookie(cookie);
		}
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(500);
		System.out.println("Current Thread " + Thread.currentThread().getId());
		System.out.println("Driver " + getDriver());
		getDriver().quit();
		
		
	}
}
