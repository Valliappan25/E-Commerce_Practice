package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testing.POM.BasePage;

public class CartPage extends BasePage {

	//private By productName = By.cssSelector("td[class='product-name'] a");
	//private By checkOut = By.cssSelector(".wc-forward");
	
	@FindBy(css = "td[class='product-name'] a")
	private WebElement productName;
	
	@FindBy(css = ".wc-forward")
	private WebElement checkOut;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String viewProductName()
	{
		//WebElement productElement = driver.findElement(productName);
		wait.until(ExpectedConditions.visibilityOf(productName));
		return productName.getText();
	}
	
	public CheckoutPage checkOutProductFromCart()
	{
		checkOut.click();
		return new CheckoutPage(driver);
	}
}
