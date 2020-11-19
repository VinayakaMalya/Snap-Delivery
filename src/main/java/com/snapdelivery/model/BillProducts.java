package com.snapdelivery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billProducts")
public class BillProducts 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILLPRODUCTID")
    private Integer billsProductId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="PRODUCTID", referencedColumnName="PRODUCTID")
//    private Product product;
	
	@Column(name = "PRODUCTID")
	private Integer productId;
	
	@Column(name = "PRODUCTNAME")
    private String productName;
	
	@Column(name = "PRICE")
    private Double price;  
	
	@Column(name="SIZE")
	private String size;
	
	@Column(name="UNIT")
	private String unit;
	
	@Column(name="QUANTITY")
	private Integer quantity;

	public Integer getBillsProductId() {
		return billsProductId;
	}

	public void setBillsProductId(Integer billsProductId) {
		this.billsProductId = billsProductId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
