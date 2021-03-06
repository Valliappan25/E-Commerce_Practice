package com.testing.E_Commerce;


import java.io.IOException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.testing.POJO.BillingAddress;
import com.testing.POJO.User;
import com.testing.POJO.Product;
import com.testing.POM.BaseTest;
import com.testing.Utilities.ConfigLoader;
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
		loadURL("/");
		
		BillingAddress billingAddress = JacksonUtilities.deserializeJson("myBillingDetails.json", BillingAddress.class);
		
		StorePage storePage = new HomePage(getDriver()).clickStoreLink();
		
		storePage.search("Blue");
		Thread.sleep(1000);
		System.out.println(storePage.getTitle());
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		Product product = new Product(1215);
		storePage.addProductToCart(product.getName());
		
		CartPage cartPage = storePage.viewElementsinCart();
		
		cartPage.viewProductName();
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
				checkOut.enterBilllingDetails(billingAddress)
				.clickDirectBankTransfer()
				.placeOrder();
		
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	@Test
	public void loginAndCheckoutUsingBankTransfer() throws InterruptedException, StreamReadException, DatabindException, IOException
	{
		loadURL("/");
		BillingAddress billingAddress = JacksonUtilities.deserializeJson("myBillingDetails.json", BillingAddress.class);

		HomePage homePage = new HomePage(getDriver());
		StorePage storePage = homePage.clickStoreLink();
		
		storePage.search("Blue");
		Assert.assertTrue(storePage.getTitle().contains("Search results"));
		Product product = new Product(1215);
		storePage.addProductToCart(product.getName());
		
		CartPage cartPage = storePage.viewElementsinCart();
		Assert.assertEquals(cartPage.viewProductName(), product.getName());
		CheckoutPage checkOut = cartPage.checkOutProductFromCart();
		
		checkOut.clickLoginLink();
	
		//Login login = JacksonUtilities.deserializeJson("login.json", Login.class);
		User login = new User(ConfigLoader.getInstance().getUserName(),
				ConfigLoader.getInstance().getPassword());
		checkOut.enterLoginDetails(login)
		.clickLogin();
		checkOut.enterBilllingDetails(billingAddress)
		.clickDirectBankTransfer();
		checkOut.placeOrder();
		
		Assert.assertEquals(checkOut.getNotice(), "Thank you. Your order has been received.");	
	}
	
	
	
	
}
