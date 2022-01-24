package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testing.POM.BasePage;

public class CartPage extends BasePage {

	private By productName = By.cssSelector("td[class='product-name'] a");
	private By checkOut = By.cssSelector(".wc-forward");
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String viewProductName()
	{
		WebElement productElement = driver.findElement(productName);
		wait.until(ExpectedConditions.visibilityOf(productElement));
		return productElement.getText();
	}
	
	public CheckoutPage checkOutProductFromCart()
	{
		driver.findElement(checkOut).click();
		return new CheckoutPage(driver);
	}
}
