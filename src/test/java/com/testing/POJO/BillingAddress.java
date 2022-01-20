package com.testing.POJO;

public class BillingAddress {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String postalCode;
	private String email;
	
	public BillingAddress()
	{
		
	}
	
	public BillingAddress(String firstName, String lastName, String address, String city, 
			String postalCode, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public BillingAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public BillingAddress setLastName(String lastNmae) {
		this.lastName = lastNmae;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public BillingAddress setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getCity() {
		return city;
	}
	public BillingAddress setCity(String country) {
		this.city = country;
		return this;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public BillingAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	public String getEmail() {
		return email;
		
	}
	public BillingAddress setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
}
