package com.testing.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	public static Properties propertyLoader(String filePath) throws IOException
	{
		Properties prop = new Properties();
		BufferedReader reader;
		
		reader = new BufferedReader(new FileReader(filePath));

		prop.load(reader);
		reader.close();
		return prop;
		
	}
}
