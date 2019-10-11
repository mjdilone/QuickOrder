package com.ds.quickOrder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.service.SaleItemServiceImpl;

@Controller
//@RequestMapping("/SaleItem")
public class SaleItemController {
	
	@Autowired
	private SaleItemServiceImpl saleItemService;
	
	ModelAndView model;

	@RequestMapping(value = {"/", "list"}, method=RequestMethod.GET)
	public ModelAndView getAllSaleItems() {
		model = new ModelAndView();
		
		List<SaleItem> list = saleItemService.getAllSaleItems();		
		
		model.addObject("saleItem_list",list);
		model.setViewName("saleItem_list");
		
		return model;
	}
	
	
	//For testing
	@RequestMapping(value = {"/","test"},method=RequestMethod.GET)
	public ModelAndView testing() {
		model = new ModelAndView();
		String message = "this message is being sent from within the controller method";
		
		model.addObject("messageToPass", message);
		model.setViewName("test");
		
		return model;
	}
	
	//For testing correct values being given to DB
	@RequestMapping(value = {"/","next"},method=RequestMethod.GET)
	public ModelAndView testingNext() {
		model = new ModelAndView();
		String message = "this message is being sent from within the next method";
		
		model.addObject("messageToPass", message);
		model.setViewName("next");
		
		return model;
	}
	
	
	@RequestMapping(value = {"/","itemInfo"},method=RequestMethod.GET)
	public ModelAndView getItemInfo(@RequestParam int id) {
		model = new ModelAndView();
		
		SaleItem item = saleItemService.findSaleItemById(id); 
		
		model.addObject("saleItem",item);
		model.setViewName("itemInfo");
		
		return model;
		
	}
	
	
	
}