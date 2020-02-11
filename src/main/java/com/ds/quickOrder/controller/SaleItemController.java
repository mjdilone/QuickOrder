package com.ds.quickOrder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.service.HelperServiceImpl;
import com.ds.quickOrder.service.SaleItemServiceImpl;

@Controller
public class SaleItemController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	private SaleItemServiceImpl saleItemService;
	
	ModelAndView model = new ModelAndView();
	


	@RequestMapping(value = {"/", "list"}, method=RequestMethod.GET)
	public ModelAndView getAllSaleItems(
			@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
			@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId, 
			@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString) {
		
		try {
			List<SaleItem> list = saleItemService.getAllSaleItems();
			int cartCount;
			
			if(cookieUsername.equalsIgnoreCase("emptyCookieUsername")) {
				cartCount = saleItemService.retrieveCartCount(cookieUserId,true);
			} else {
				cartCount = saleItemService.retrieveCartCount(cookieUserId,false);
			}
			
			helper.prepModel(model, cartCountCookieString, cookieUsername,cookieUserId);//what this does has to be rewritten
			model.addObject("saleItem_list",list);			
			model.setViewName("saleItem_list");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("CookieUserI: " + cookieUserId);
		}
		return model;
	}
	
	
	
	//For testing correct values being given to DB
	@RequestMapping(value = {"/","next"},method=RequestMethod.GET)
	public ModelAndView testingNext() {
		try {
			String message = "this message is being sent from within the next method";
			
			model.addObject("messageToPass", message);
			model.setViewName("next");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	@RequestMapping(value = {"/","itemInfo"},method=RequestMethod.GET)
	public ModelAndView getItemInfo(@RequestParam int id) {
		try {
			SaleItem item = saleItemService.findSaleItemById(id); 
			
			model.addObject("saleItem",item);
			model.setViewName("itemInfo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping(value = {"/","searchSaleItem"},method=RequestMethod.GET)
	public ModelAndView searchSaleItem(@RequestParam String name) {
		try {
			List<SaleItem> allItems = saleItemService.searchSaleItemByName(name);
			
			model.addObject("saleItem_list",allItems);
			model.setViewName("saleItem_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = {"/","searchSaleItemCategory"},method=RequestMethod.GET)
	public ModelAndView searchSaleItemCategory(@RequestParam String name) {
		
		try {
			List<SaleItem> searchResult = saleItemService.searchSaleItemByName(name);
			
			model.addObject("saleItem_list",searchResult);
			model.setViewName("saleItem_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}