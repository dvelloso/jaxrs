package br.com.dvb.jaxrs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private String email;
	private Address address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, Address address) {
		super();
		this.email = email;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}
	
	

}
