package com.snapdelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTID")
	private Integer clientId;
	
	@Column(name = "CLIENTNAME")
    private String name;
	
	@Column(name = "ADDRESS")
    private String address;
	
	@Column(name="PHONENUMBER")
	private Integer phoneNumber;
	
	@Column(name="SERVICECATEGORYID")
    private Integer serviceCategoryId;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getServiceCategoryId() {
		return serviceCategoryId;
	}

	public void setServiceCategoryId(Integer serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}
}
