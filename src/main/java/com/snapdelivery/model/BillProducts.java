package com.snapdelivery.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billProducts")
public class BillProducts 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILLPRODUCTID")
    private Integer billsProductId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BILLID")
	private Bill bill;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PRODUCTID", referencedColumnName="PRODUCTID")
    private Product product;

	public Integer getBillsProductId() {
		return billsProductId;
	}

	public void setBillsProductId(Integer billsProductId) {
		this.billsProductId = billsProductId;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
