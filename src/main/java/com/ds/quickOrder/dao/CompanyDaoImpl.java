package com.ds.quickOrder.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.CompanyEntity;
import com.ds.quickOrder.repo.CompanyRepo;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	CompanyRepo repo;
	
	@Override
	public Company findCompany(String name) {
		CompanyEntity companyEntity= repo.findByName(name);
		return companyEntity;
	}

}
