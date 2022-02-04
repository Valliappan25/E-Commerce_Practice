package com.testing.E_Commerce;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testing.POM.BaseTest;
import com.testing.pages.HomePage;
import com.testing.pages.StorePage;

import junit.framework.Assert;

public class NavigationTest extends BaseTest {
	
	@Test
	public void navigateFromHomeToStorePage() throws IOException
	{
		loadURL("/");
	StorePage storePage = new HomePage(getDriver()).clickStoreLink();
		
		System.out.println(storePage.getTitle());
		Assert.assertEquals(storePage.getTitle(), "Store");
	}

}
