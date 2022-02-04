package com.testing.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testing.POM.BasePage;
import com.testing.POM.BaseTest;


public class StorePage extends BasePage{

	//protected WebDriver driver;
	
	private By searchField = By.id("woocommerce-product-search-field-0");
	private By searchButton = By.cssSelector("button[value='Search']");
	private By title = By.cssSelector(".woocommerce-products-header__title");
	private By viewCart = By.cssSelector("a[title='View cart']");
	private BaseTest base;
	public StorePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	private StorePage productName(String text)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
		driver.findElement(searchField).sendKeys(text);
		return this;
	}
	
	private StorePage searchProduct()
	{
		driver.findElement(searchButton).click();
		return this;
	}
	
	public StorePage search(String text)
	{
		productName(text).searchProduct();
		
		return this;
	}
	
	public String getTitle()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		return driver.findElement(title).getText();	
	}
	
	private By getAddToCartButtonElement(String productName)
	{
		return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
	}
	
	public StorePage addProductToCart(String productName)
	{
		By addToCartButton = getAddToCartButtonElement(productName);
		driver.findElement(addToCartButton).click();
		return this;
	}
	
	public CartPage viewElementsinCart() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
		driver.findElement(viewCart).click();
		return new CartPage(driver);
	}

}
