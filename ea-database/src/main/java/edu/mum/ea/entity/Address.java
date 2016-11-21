package edu.mum.ea.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class Address {
	@NotNull(message="field.requered")
	private String street;
	@NotNull(message="field.requered")
	private String state;
	@NotNull(message="field.requered")
	private String city;
	@NotNull(message="field.requered")
	private String zipCode;
	@NotNull(message="field.requered")
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
