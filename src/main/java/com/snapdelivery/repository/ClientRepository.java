package com.snapdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapdelivery.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>
{

	List<Client> findByServiceCategoryId(Integer serviceCategoryId);

	Client findByClientIdAndServiceCategoryId(Integer clientId, Integer serviceCategoryId);
}
