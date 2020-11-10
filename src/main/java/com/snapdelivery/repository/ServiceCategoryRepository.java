package com.snapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapdelivery.model.ServiceCategory;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Integer>
{
	ServiceCategory findByServiceCategoryId(Integer serviceCategoryId);
}
