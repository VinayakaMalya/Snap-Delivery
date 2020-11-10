package com.snapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapdelivery.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer>
{
	Bill findByBillId(Integer billId);

}
