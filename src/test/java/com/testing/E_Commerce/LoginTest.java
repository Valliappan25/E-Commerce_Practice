package com.testing.E_Commerce;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testing.POJO.Product;
import com.testing.POJO.User;
import com.testing.POM.BaseTest;
import com.testing.Utilities.FakerUtils;
import com.testing.pages.CheckoutPage;

import apiAction.CartAPI;
import apiAction.SignUpAPI;

public class LoginTest extends BaseTest {

	@Test
	public void loginDuringCheckOut() throws IOException, InterruptedException
	{
		SignUpAPI signup = new SignUpAPI();
		FakerUtils faker = new FakerUtils();
		User user = new User();
		
		String username = "sample"+faker.randomNumber();
		user.setUsername(username);
		user.setEmail(username+"@email.com");
		user.setPassword("smaple1234");
		
		signup.register(user);
		CartAPI cart = new CartAPI();
		Product product = new Product(1215);
		cart.addToCart(product.getId(), 1);
		
		CheckoutPage checkOut = new CheckoutPage(getDriver());
		loadURL("/checkout/");
		Thread.sleep(5000);
		injectCookiesToBrowser(cart.getCookies());
		loadURL("/checkout/");
		Thread.sleep(5000);
		checkOut.clickLoginLink();
		checkOut.enterLoginDetails(user);
		checkOut.clickLogin();
		Thread.sleep(5000);
		Assert.assertTrue(checkOut.getProductName().contains(product.getName()));
	}
}
