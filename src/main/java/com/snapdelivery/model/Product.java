package com.snapdelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTID")
	private Integer productId;
	
	@Column(name = "PRODUCTNAME")
    private String productName;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Column(name = "PRICE")
    private Double price;  
	
	@Column(name="SIZE")
	private String size;
	
	@Column(name="UNIT")
	private String unit;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="CLIENTID")
    private Integer clientId;
	
	@OneToOne(mappedBy = "product")
	private BillProducts billProducts;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public BillProducts getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(BillProducts billProducts) {
		this.billProducts = billProducts;
	}
}
