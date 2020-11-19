package com.snapdelivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapdelivery.model.Bill;
import com.snapdelivery.model.BillStatus;
import com.snapdelivery.model.Client;
import com.snapdelivery.model.Delivery;
import com.snapdelivery.model.Payment;
import com.snapdelivery.model.PaymentStatus;
import com.snapdelivery.model.Product;
import com.snapdelivery.model.ServiceCategory;
import com.snapdelivery.repository.BillRepository;
import com.snapdelivery.repository.ClientRepository;
import com.snapdelivery.repository.ProductRepository;
import com.snapdelivery.repository.ServiceCategoryRepository;
import com.snapdelivery.repository.UserRepository;

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
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Bill getBillByBillId(Integer billId) 
	{
		return billRepository.findByBillId(billId);
	}	
	
	@Override
	public List<Bill> getOrderByOrdeId(Integer userId) 
	{
		List<Bill> bills = billRepository.findAll();
		List<Bill> nBills = new ArrayList<>();
		if(!bills.isEmpty() && bills!=null)
		{
			for(Bill bill : bills)
			{
				if(userId==bill.getUser().getUserId())
				{
					nBills.add(bill);
				}
			}
			return nBills;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Bill paynow(Bill bill) 
	{
		bill.setBillStatus(BillStatus.COMPLETED);
		bill.setBillProducts(null);
		Payment payment = bill.getPayment();
		payment.setPaymentStatus(PaymentStatus.APPROVED);
		Bill nBill =  billRepository.save(bill);
		nBill.setUser(userRepository.findByUserId(nBill.getUser().getUserId()));
		nBill.setClient(clientRepository.findByClientId(nBill.getClient().getClientId()));
		return nBill;
	}
	
	@Override
	public Bill checkout(Bill bill) 
	{
		bill.setBillStatus(BillStatus.COMPLETED);
		Payment payment = bill.getPayment();
		payment.setPaymentStatus(PaymentStatus.APPROVED);
		Bill nBill =  billRepository.save(bill);
		nBill.setUser(userRepository.findByUserId(nBill.getUser().getUserId()));
		nBill.setClient(clientRepository.findByClientId(nBill.getClient().getClientId()));
		return nBill;
	}

	@Override
	public Integer getPackageCostOnAddressAndType(Delivery delivery,Integer typeId) 
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
