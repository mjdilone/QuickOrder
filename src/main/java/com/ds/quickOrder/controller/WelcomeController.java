package com.ds.quickOrder.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.service.HelperServiceImpl;
import com.ds.quickOrder.service.WelcomeServiceImpl;

@Controller
public class WelcomeController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	WelcomeServiceImpl welcomeService;
	
	ModelAndView model = new ModelAndView();
		
	@RequestMapping(value = {"/","welcome"},method=RequestMethod.GET)
	public ModelAndView welcome(
	HttpServletResponse respone,
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername
) {
		try {
				Company company = welcomeService.retrieveCompany();
				List<Category> categories =  welcomeService.getAllCategories();
				
				
				model.addObject("company",company);
				model.addObject("categories",categories);
				if(cookieUsername.equalsIgnoreCase("emptyCookieUsername")) {
					model.addObject("username","Guest");
				}else {
					model.addObject("username",cookieUsername);
				}
				
				model.setViewName("welcome");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
		
		@RequestMapping(value = {"/","category"},method=RequestMethod.GET)
		public ModelAndView category(@RequestParam String categoryToSearch) {
			try {
				Category category = welcomeService.retrieveCategory(categoryToSearch);
				List<SaleItem> categoryItems = welcomeService.searchSaleItemByCategory(category);
				
				log.info("All items");
				for(SaleItem i : categoryItems) {
					log.info(i.toString());
				}
				log.info("All items printed");
				
				model.addObject("categoryItems",categoryItems);
				model.setViewName("category");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
}