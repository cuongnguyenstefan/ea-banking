package edu.mum.ea.entity;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;


@Embeddable
public class Address {
	@NotEmpty(message="Street is Requered")
	private String street;
	@NotEmpty(message="State is Requered")
	private String state;
	@NotEmpty(message="City is Requered")
	private String city;
	@NotEmpty(message="Zipcode is Requered")
	private String zipCode;
	@NotEmpty(message="Country is Requered")
	private String country;
		
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
