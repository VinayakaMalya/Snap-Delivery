package com.snapdelivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name= "BILLID")
	private Integer billId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAYMENTID", referencedColumnName="PAYMENTID")
	private Payment payment;
	
	@Enumerated(EnumType.STRING)
	@Column(name="BILLSTATUS")
	private BillStatus billStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERYID", referencedColumnName="DELIVERYID")
	private Delivery delivery;
	
	@OneToOne
    @JoinColumn(name = "CLIENTID", referencedColumnName="CLIENTID")
    private Client client;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="BILLID")
	private List<BillProducts> billProducts;
	
	@OneToOne
	@JoinColumn(name = "USERID", referencedColumnName="USERID")
    private User user;
	    
	@Column(name = "NOTE")
	private String note;
	
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public BillStatus getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<BillProducts> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProducts> billProducts) {
		this.billProducts = billProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
