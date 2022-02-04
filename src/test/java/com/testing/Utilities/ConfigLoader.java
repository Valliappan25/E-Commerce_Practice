package com.testing.Utilities;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	public final Properties properties;
	private static ConfigLoader loader;
	
	private ConfigLoader() throws IOException{
		this.properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
		
	}
	
	public static ConfigLoader getInstance() throws IOException
	{
		if (loader == null)
				loader = new ConfigLoader();
		return loader;
	}
	
	public String getURL()
	{
		String baseURL = properties.getProperty("url");
		if (baseURL != null)
			return baseURL;
		else throw new RuntimeException("Unable to load URL from Properties file");
	}
	public String getUserName()
	{
		String userName = properties.getProperty("username");
		if (userName != null)
			return userName;
		else throw new RuntimeException("Unable to load Username from Properties file");
	}
	public String getPassword()
	{
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else throw new RuntimeException("Unable to load Password from Properties file");
	}
}
