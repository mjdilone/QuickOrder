package com.ds.quickOrder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer> {

	@Query("select c from CompanyEntity c where name = :name")
	CompanyEntity findByName(String name);

}