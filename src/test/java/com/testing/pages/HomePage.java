package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.POM.BasePage;

public class HomePage extends BasePage {

	private By storeLink = By.cssSelector("a[class='wp-block-button__link']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public StorePage clickStoreLink()
	{
		driver.findElement(storeLink).click();
		
		return new StorePage(driver);
	}
}
