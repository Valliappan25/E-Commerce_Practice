package com.testing.E_Commerce;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testing.POJO.Product;
import com.testing.POM.BaseTest;
import com.testing.pages.CartPage;
import com.testing.pages.StorePage;

import junit.framework.Assert;

public class AddToCartTest extends BaseTest {

	@Test
	public void addToCartFromStorePage() throws IOException
	{
		loadURL("/store");
		Product product = new Product(1215);
		StorePage storePage = new StorePage(getDriver());
		storePage.addProductToCart(product.getName());
		
		CartPage cartPage = storePage.viewElementsinCart();
		Assert.assertEquals(cartPage.viewProductName(), product.getName());
	}
}
