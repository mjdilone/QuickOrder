package com.ds.quickOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.SaleItemDaoImpl;
import com.ds.quickOrder.model.SaleItem;

@Service
public class SaleItemServiceImpl implements SaleItemService{

	@Autowired
	private SaleItemDaoImpl saleItemDao;
	
	@Override
	public List<SaleItem> getAllSaleItems() {
		
		return saleItemDao.getAllSaleItems();
	}

	@Override
	public SaleItem findSaleItemById(int id) {
		return saleItemDao.findSaleItemById(id);
	}

	@Override
	public SaleItem findSaleItemByName(String name) {
		return saleItemDao.findSaleItemByName(name);
	}

	

}
