package com.testing.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;

import io.restassured.http.Cookies;

public class CookieUtils {

	public List<Cookie> convertRestAssuredToSeleniumCookies(Cookies cookies)
	{
		List<io.restassured.http.Cookie> restAssuredCookie = new ArrayList<>();
		restAssuredCookie = cookies.asList();
		List<Cookie> seleniumCookies = new ArrayList<>();
		
		for(io.restassured.http.Cookie cookie : restAssuredCookie)
		{
			seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getExpiryDate(),
					cookie.isSecured(), cookie.isHttpOnly(), cookie.getSameSite()));
		}
		
		return seleniumCookies;
	}
}
