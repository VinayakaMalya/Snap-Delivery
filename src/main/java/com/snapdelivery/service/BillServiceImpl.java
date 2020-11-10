package com.snapdelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapdelivery.model.Bill;
import com.snapdelivery.model.BillStatus;
import com.snapdelivery.model.Client;
import com.snapdelivery.model.Delivery;
import com.snapdelivery.model.PaymentStatus;
import com.snapdelivery.model.Product;
import com.snapdelivery.model.ServiceCategory;
import com.snapdelivery.repository.BillRepository;
import com.snapdelivery.repository.ClientRepository;
import com.snapdelivery.repository.ProductRepository;
import com.snapdelivery.repository.ServiceCategoryRepository;

@Service
public class BillServiceImpl implements BillService
{
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ServiceCategoryRepository serviceRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Bill sendPackage(Bill bill) 
	{
		Bill nBill = new Bill();
		nBill.setBillStatus(BillStatus.PENDING);
		nBill.setNote(bill.getNote());
		nBill.setDelivery(bill.getDelivery());
		// payment cost is 50 and status is pending
		nBill.setPayment(bill.getPayment());
		return billRepository.save(nBill);
	}
	
	@Override
	public Bill getOrderByOrdeId(Integer billId) 
	{
		return billRepository.findByBillId(billId);
	}	
	
	@Override
	public Bill paynow(Bill bill) 
	{
		Bill nBill = billRepository.findByBillId(bill.getBillId());
		if(nBill!=null)
		{
			nBill.setBillId(bill.getBillId());
			nBill.setBillStatus(BillStatus.COMPLETED);
			bill.getPayment().setPaymentStatus(PaymentStatus.APPROVED);
			nBill.setPayment(bill.getPayment());
			nBill.setDelivery(bill.getDelivery());
			return billRepository.save(nBill);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Bill checkout(Bill bill) 
	{
		Bill nBill = new Bill();
		nBill.setBillStatus(BillStatus.PENDING);
		nBill.getPayment().setPaymentStatus(PaymentStatus.PENDING);
		nBill.setPayment(bill.getPayment());
		nBill.setBillProducts(bill.getBillProducts());
		return billRepository.save(nBill);
	}

	@Override
	public Integer getPackageCostOnAddress(Delivery delivery) 
	{
		return 50;
	}

	@Override
	public List<ServiceCategory> getServices() 
	{
		return serviceRepository.findAll();
	}
	
	@Override
	public List<ServiceCategory> createService(List<ServiceCategory> service) 
	{
		if(service!=null && !service.isEmpty())
		{
			return serviceRepository.saveAll(service);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<Client> addClientsByServiceId(List<Client> client) 
	{
		return clientRepository.saveAll(client);
	}

	@Override
	public List<Client> getClientsByServiceId(Integer serviceCategoryId) 
	{
		return clientRepository.findByServiceCategoryId(serviceCategoryId);
	}

	@Override
	public List<Product> getClientProducts(Integer serviceCategoryId, Integer clientId) 
	{
		Client client = clientRepository.findByClientIdAndServiceCategoryId(clientId, serviceCategoryId);
		if(client!=null)
		{
			return  productRepository.findByClientId(clientId);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Product> addClientProducts(Integer serviceCategoryId, Integer clientId,
			List<Product> product)
	{
		if(product!=null && !product.isEmpty())
		{
			return productRepository.saveAll(product);
		}
		else
		{
			return null;
		}
	}
}
