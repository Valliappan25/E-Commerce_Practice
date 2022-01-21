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
import com.testing.POJO.Login;
import com.testing.POJO.Product;
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
		 
		
		BillingAddress billingAddress = JacksonUtilities.deserializeJson("myBillingDetails.json", BillingAddress.class);
		
		HomePage homePage = new HomePage(driver);
		StorePage storePage = homePage.clickStoreLink();
		
		storePage.search("Blue");
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		Product product = new Product(1215);
		storePage.addProductToCart(product.getName());
		
		CartPage cartPage = storePage.viewElementsinCart();
		
		cartPage.viewProductName();
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
				checkOut.enterBilllingDetails(billingAddress);
		
		checkOut.placeOrder();
		
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	@Test
	public void loginAndCheckoutUsingBankTransfer() throws InterruptedException, StreamReadException, DatabindException, IOException
	{
		
		BillingAddress billingAddress = JacksonUtilities.deserializeJson("myBillingDetails.json", BillingAddress.class);

		
		HomePage homePage = new HomePage(driver);
		StorePage storePage = homePage.clickStoreLink();
		
		storePage.search("Blue");
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		Product product = new Product(1215);
		storePage.addProductToCart(product.getName());
		//Thread.sleep(5000);
		CartPage cartPage = storePage.viewElementsinCart();
		
		cartPage.viewProductName();
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
		
		checkOut.clickLoginLink();
		//Thread.sleep(2000);
		
		Login login = JacksonUtilities.deserializeJson("login.json", Login.class);
		checkOut.enterLoginDetails(login)
		.clickLogin();
				
		checkOut.enterBilllingDetails(billingAddress);
		//Thread.sleep(2000);
		checkOut.placeOrder();
		//Thread.sleep(5000);
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	
	
	
}
