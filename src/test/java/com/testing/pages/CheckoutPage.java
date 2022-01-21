package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.POJO.BillingAddress;
import com.testing.POJO.Login;
import com.testing.POM.BasePage;

public class CheckoutPage extends BasePage {

	private By loginLink = By.cssSelector("a.showlogin");
	private By userName = By.id("username");
	private By password = By.name("password");
	private By loginButton = By.name("login");
	private By firstNameField = By.id("billing_first_name");
	private By lastNameField = By.id("billing_last_name");
	private By billingAddressField = By.id("billing_address_1");
	private By billingCityField = By.id("billing_city");
	private By bilingPostcodeField = By.id("billing_postcode");
	private By emailField =  By.id("billing_email");
	private By placeOrderButton = By.id("place_order");
	private By notice = By.cssSelector(".woocommerce-notice");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CheckoutPage clickLoginLink() {
		
		
		driver.findElement(loginLink).click();
		return this;
	}

	public CheckoutPage enterUserName(String userLoginName)
	{
		
		driver.findElement(userName).sendKeys(userLoginName);
		return this;
	}
	
	public CheckoutPage enterPassword(String loginPassword)
	{
	
		driver.findElement(password).sendKeys(loginPassword);
		return this;
	}
	
	public CheckoutPage clickLogin()
	{
	
		driver.findElement(loginButton).click();
		return this;
	}
	
	public CheckoutPage enterFirstName(String fName)
	{
		driver.findElement(firstNameField).clear();
		driver.findElement(firstNameField).sendKeys(fName);
		return this;
	}
	
	public CheckoutPage enterLastName(String lName)
	{
		driver.findElement(lastNameField).clear();
		driver.findElement(lastNameField).sendKeys(lName);
		return this;
	}
	
	public CheckoutPage enterBillingAddress(String address)
	{
		driver.findElement(billingAddressField).clear();
		driver.findElement(billingAddressField).sendKeys(address);
		return this;
	}
	
	public CheckoutPage enterBillingCity(String city)
	{
		driver.findElement(billingCityField).clear();
		driver.findElement(billingCityField).sendKeys(city);
		return this;
	}
	
	public CheckoutPage enterPostalCode(String postalCode)
	{
		driver.findElement(bilingPostcodeField).clear();
		driver.findElement(bilingPostcodeField).sendKeys(postalCode);
		return this;
	}
	
	public CheckoutPage enterEmailAddress(String email)
	{
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
		return this;
	}
	
	public CheckoutPage placeOrder()
	{
		driver.findElement(placeOrderButton).click();
		System.out.println("Order Placed");
		return this;
	}
	
	public CheckoutPage enterBilllingDetails(BillingAddress billingAddress)
	{
		return enterFirstName(billingAddress.getFirstName())
		.enterLastName(billingAddress.getLastName())
		.enterBillingAddress(billingAddress.getAddress())
		.enterBillingCity(billingAddress.getCity())
		.enterPostalCode(billingAddress.getPostalCode())
		.enterEmailAddress(billingAddress.getEmail());	
	}
	
	public CheckoutPage enterLoginDetails(Login login)
	{
		return enterUserName(login.getEmail())
				.enterPassword(login.getPassword());
	}
	
	public String getNotice()
	{
		return driver.findElement(notice).getText();
	}

}
