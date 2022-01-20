package com.testing.Utilities;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.POJO.BillingAddress;

public class JacksonUtilities {

	public static BillingAddress deserializeJson(InputStream input, BillingAddress billingAddress) throws StreamReadException, DatabindException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue( input, billingAddress.getClass());
	}
}
