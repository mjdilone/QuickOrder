package com.ds.quickOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.CartDaoImpl;
import com.ds.quickOrder.dao.SaleItemDaoImpl;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;

@Service
public class SaleItemServiceImpl implements SaleItemService{

	@Autowired
	private SaleItemDaoImpl saleItemDao;
	
	@Autowired
	private CartDaoImpl cartDao;
	
	@Override
	public List<SaleItem> getAllSaleItems() {
		List<SaleItem> allItems = null;
		
		try {
			allItems = saleItemDao.getAllSaleItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allItems;
	}

	@Override
	public SaleItem findSaleItemById(int id) {
		SaleItem itemToSearch = null;
		
		try {
			itemToSearch = saleItemDao.findSaleItemById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemToSearch;
	}

	@Override
	public SaleItem findSaleItemByName(String name) {
		SaleItem itemToSearch = null;
		
		try {
			itemToSearch = saleItemDao.findSaleItemByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return itemToSearch;
	}

	@Override
	public List<SaleItem> searchSaleItemByName(String name) {
		List<SaleItem> result = null;
		
		
		try {
			result = saleItemDao.searchSaleItemByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<SaleItem> searchSaleItemByCategory(Category category) {
		List<SaleItem> result = null;
		
		try {
			result = saleItemDao.searchSaleItemByCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int retrieveCartCount(String userId,Boolean isGuest) {
		int count;
		
		try {
			
			if(isGuest) {
				count = cartDao.retrieveGuestCart(Integer.parseInt(userId)).size();
				System.out.println("the size in service for guest  is " + count);
			}else {
				 count = cartDao.retrieveCart(Integer.parseInt(userId)).size();
				 System.out.println("the size in service for logged in user is " + count);
			}
		} catch (Exception e) {
			System.out.println("exception has been caught in retrieveCartCount");
			count = 0;
		}
		
		return count;
	}
}