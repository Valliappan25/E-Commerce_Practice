package com.testing.Utilities;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.POJO.BillingAddress;

public class JacksonUtilities {

	public static <T> T deserializeJson(String fileName, Class<T> T) throws StreamReadException, DatabindException, IOException 
	{
		InputStream input = JacksonUtilities.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(input, T);
	}
}
