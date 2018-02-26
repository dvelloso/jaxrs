package br.com.dvb.jaxrs.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	
	private Long id;
	private String name;
	private BigDecimal value;
	private Long quantitiy;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id, String name, BigDecimal value, Long quantitiy) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.quantitiy = quantitiy;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Long getQuantitiy() {
		return quantitiy;
	}
	
	

}
