package com.testing.E_Commerce;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testing.POM.BaseTest;
import com.testing.pages.StorePage;

import junit.framework.Assert;

public class SearchTest extends BaseTest {

	@Test
	public void searchWithPartialMatch() throws IOException
	{
		loadURL("/store");
		StorePage storePage = new StorePage(getDriver());
		storePage.search("Blue");
		Assert.assertTrue(storePage.getTitle().contains("Search results"));
	}
}
