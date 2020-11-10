package com.snapdelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snapdelivery.model.Client;
import com.snapdelivery.model.Delivery;
import com.snapdelivery.model.Product;
import com.snapdelivery.model.Bill;
import com.snapdelivery.model.ServiceCategory;
import com.snapdelivery.service.BillService;

@RestController
public class BillController 
{
	@Autowired
	private BillService billService;
	
	@PostMapping("bill/sendPackage")
	public Bill sendPackage(@RequestBody Bill bill)
	{
		return billService.sendPackage(bill);
	}
	
	@GetMapping("bill/{billId}")
	public Bill getOrderByOrdeId(@PathVariable("billId") Integer billId)
	{
		return billService.getOrderByOrdeId(billId);
	}
	
	// Send Package payment screen
	@PostMapping("package/paynow")
	public Bill paynow(@RequestBody Bill bill)
	{
		return billService.paynow(bill);
	}
	
	// Restaurant / Food/ items checkout
	@PostMapping("product/bill")
	public Bill checkout(@RequestBody Bill bill)
	{
		return billService.checkout(bill);
	}
	
	@PostMapping("package/packageCost")
	public Integer getPackageCostOnAddress(@RequestBody Delivery delivery)
	{
		return billService.getPackageCostOnAddress(delivery);
	}
	
	@GetMapping("service")
	public List<ServiceCategory> getServices()
	{
		return billService.getServices();
	}
	
	@PostMapping("service")
	public List<ServiceCategory> createService(@RequestBody List<ServiceCategory> service)
	{
		return billService.createService(service);
	}
	
	@PostMapping("client")
	public List<Client> addClientsByServiceId(@RequestBody List<Client> client)
	{
		return billService.addClientsByServiceId(client);
	}
	
	@GetMapping("client/serviceCategory/{serviceCategoryId}")
	public List<Client> getClientsByServiceId(@PathVariable("serviceCategoryId") Integer serviceCategoryId)
	{
		return billService.getClientsByServiceId(serviceCategoryId);
	}
	
	@PostMapping("product/service/{serviceId}/client/{clientId}")
	public List<Product> addClientProducts(@PathVariable("serviceId") Integer serviceId,
										@PathVariable("clientId") Integer clientId,
										@RequestBody List<Product> product)
	{
		return billService.addClientProducts(serviceId,clientId,product);
	}
	
	@GetMapping("/product/service/{serviceId}/client/{clientId}")
	public List<Product> getClientProducts(@PathVariable("serviceId") Integer serviceId,
										@PathVariable("clientId") Integer clientId)
	{
		return billService.getClientProducts(serviceId,clientId);
	}
}
