package com.testing.POJO;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.testing.Utilities.JacksonUtilities;

public class Product {

	private int id;
	private String name;
	
	public Product() {}
	
	public Product(int id) throws StreamReadException, DatabindException, IOException
	{
		Product[] products = JacksonUtilities.deserializeJson("products.json", Product[].class);
		
		for(Product product:products)
		{
			if(product.getId() == id)
			{
				this.id = id;
				this.name = product.getName();
			}
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
