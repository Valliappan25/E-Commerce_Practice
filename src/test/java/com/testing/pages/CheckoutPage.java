package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
	private By billingCountry = By.id("billing_country");
	private By billingState = By.id("billing_state");
	private By billingCityField = By.id("billing_city");
	private By bilingPostcodeField = By.id("billing_postcode");
	private By emailField =  By.id("billing_email");
	private By directBankTransferRadioButton = By.id("payment_method_bacs");
	private By placeOrderButton = By.id("place_order");
	private By notice = By.cssSelector(".woocommerce-notice");
	private By overlay = By.cssSelector(".blockUI.blockOverlay");
	private By alternateContryOption = By.id("select2-billing_country-container");
	private By alternateStateOption = By.id("select2-billing_state-container");
	
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
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
		WebElement firstNameElement = driver.findElement(firstNameField);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameElement)).clear();;
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
	
	public CheckoutPage enterBillingCountry(String country)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(billingCountry));
		Select selectCountry = new Select(driver.findElement(billingCountry));
		selectCountry.selectByVisibleText(country);
		
//		wait.until(ExpectedConditions.elementToBeClickable(alternateContryOption));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billing_country\"]/option[103]")));
//		((JavascriptExecutor) driver).executeScript("argumrnts[0].scrollIntoView(true);", element);
//		element.click();
		return this;
	}
	
	public CheckoutPage enterBillingstate(String state)
	{
		Select selectCountry = new Select(driver.findElement(billingState));
		selectCountry.selectByVisibleText(state);
		
//		wait.until(ExpectedConditions.elementToBeClickable(alternateStateOption));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+state+"']")));
//		((JavascriptExecutor) driver).executeScript("argumrnts[0].scrollIntoView(true);", element);
//		element.click();
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
	
	public CheckoutPage clickDirectBankTransfer()
	{
		WebElement radioElement = driver.findElement(directBankTransferRadioButton);
		
		if(!radioElement.isSelected())
			radioElement.click();
		
		return this;
	}
	
	public CheckoutPage placeOrder()
	{
		waitUntilOverlaystoInvisible(overlay);
		driver.findElement(placeOrderButton).click();
		System.out.println("Order Placed");
		return this;
	}
	
	public CheckoutPage enterBilllingDetails(BillingAddress billingAddress)
	{
		return enterFirstName(billingAddress.getFirstName())
		.enterLastName(billingAddress.getLastName())
		.enterBillingCountry(billingAddress.getCountry())
		.enterBillingAddress(billingAddress.getAddress())
		.enterBillingCity(billingAddress.getCity())
		.enterBillingstate(billingAddress.getState())
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(notice));
		return driver.findElement(notice).getText();
	}

}
