package com.snapdelivery.service;

import java.util.List;

import com.snapdelivery.model.Client;
import com.snapdelivery.model.Delivery;
import com.snapdelivery.model.Product;
import com.snapdelivery.model.Bill;
import com.snapdelivery.model.ServiceCategory;

public interface BillService 
{
	Bill sendPackage(Bill bill);
	
	Bill getOrderByOrdeId(Integer billId);

	Bill paynow(Bill bill);
	
	Integer getPackageCostOnAddress(Delivery delivery);
	
	List<ServiceCategory> getServices();

	List<Client> getClientsByServiceId(Integer serviceId);

	List<Product> getClientProducts(Integer serviceId, Integer clientId);

	Bill checkout(Bill bill);

	List<ServiceCategory> createService(List<ServiceCategory> service);

	List<Product> addClientProducts(Integer serviceId, Integer clientId, List<Product> product);

	List<Client> addClientsByServiceId(List<Client> client);
}
