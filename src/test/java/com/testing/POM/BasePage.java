package com.testing.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void waitUntilOverlaystoInvisible(By overlay)
	{
		List<WebElement> overlayElement = driver.findElements(overlay);
		System.out.println("Overlays in the page: "+overlayElement.size());
		
		if(overlayElement.size()>0)
		{
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlayElement));
			
			System.out.println("Overlays Invisible");
		}
		
		else
			System.out.println("Overlays not Found");
	}

}
