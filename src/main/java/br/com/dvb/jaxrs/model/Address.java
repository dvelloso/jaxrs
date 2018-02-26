package br.com.dvb.jaxrs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	private String zipCode;
	private String street;
	private String city;
	private Long number;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String zipCode, String street, String city, Long number) {
		super();
		this.zipCode = zipCode;
		this.street = street;
		this.city = city;
		this.number = number;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public Long getNumber() {
		return number;
	}
	
	
}
