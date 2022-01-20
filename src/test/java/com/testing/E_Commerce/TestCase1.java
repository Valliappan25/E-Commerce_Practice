package com.testing.E_Commerce;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.testing.POJO.BillingAddress;
import com.testing.POM.BaseTest;
import com.testing.Utilities.JacksonUtilities;
import com.testing.pages.CartPage;
import com.testing.pages.CheckoutPage;
import com.testing.pages.HomePage;
import com.testing.pages.StorePage;

import junit.framework.Assert;

public class TestCase1 extends BaseTest {

			
	@Test
	public void checkoutUsingBankTransfer() throws InterruptedException, StreamReadException, DatabindException, IOException
	{
//		BillingAddress billingAddress = new BillingAddress().
//		setFirstName("Valliappan").
//		setLastName("Ramanathan").
//		setAddress("11/1 AVPL Street").
//		setCity("California").
//		setPostalCode("90011").
//		setEmail("example@email.com");
		
		
		
//		BillingAddress billingAddress = new BillingAddress("Valliappan","Ramanathan","11/1 AVPL Street",
//				"California","90011","example@email.com" );
		BillingAddress billingAddress = new BillingAddress();
		InputStream input = getClass().getClassLoader().getResourceAsStream("Resources/myBillingDetails.json");
		billingAddress = JacksonUtilities.deserializeJson(input, billingAddress);
		
		HomePage homePage = new HomePage(driver);
		StorePage storePage = homePage.clickStoreLink();
		
		storePage.search("Blue");
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		storePage.addProductToCart("Blue Shoes");
		Thread.sleep(5000);
		CartPage cartPage = storePage.viewElementsinCart();
		
		cartPage.viewProductName();
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
				checkOut.enterBilllingDetails(billingAddress);
		Thread.sleep(2000);
		checkOut.placeOrder();
		Thread.sleep(5000);
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	@Test(dependsOnMethods = {"checkoutUsingBankTransfer"})
	public void loginAndCheckoutUsingBankTransfer() throws InterruptedException
	{
		
		HomePage homePage = new HomePage(driver);
		StorePage storePage = homePage.clickStoreLink();
		
		storePage.search("Blue");
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		storePage.addProductToCart("Blue Shoes");
		Thread.sleep(5000);
		CartPage cartPage = storePage.viewElementsinCart();
		
		cartPage.viewProductName();
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
		
		checkOut.clickLoginLink();
		Thread.sleep(2000);
		
		checkOut.enterUserName("email@example.com")
		.enterPassword("pass1234")
		.clickLogin();
				
		checkOut.enterFirstName("Valliappan")
				.enterLastName("Ramanathan")
				.enterBillingAddress("11/1 AVPL Street N.Pudur")
				.enterBillingCity("California")
				.enterPostalCode("90011")
				.enterEmailAddress("email@example.com");
		Thread.sleep(2000);
		checkOut.placeOrder();
		Thread.sleep(5000);
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	
	
	
}
