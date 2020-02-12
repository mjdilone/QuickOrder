package com.ds.quickOrder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.repo.AccountRepo;
import com.ds.quickOrder.service.AccountServiceImpl;
import com.ds.quickOrder.service.HelperServiceImpl;


@Controller
public class TestController {
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	AccountServiceImpl accountService;
	
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	ModelAndView model = new ModelAndView();
	
	@Autowired
	AccountRepo repo;
	
	//For testing
		@RequestMapping(value = {"/test"},method=RequestMethod.GET)
		public ModelAndView testing() {
			try {
				String message = "this message is being sent from within the test method";
				
				log.info("Finding user: -> {}",repo.findById(1000));
				
				model.addObject("messageToPass", message);
				model.setViewName("test");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
		
		
//		@RequestMapping(value = {"/"},method=RequestMethod.GET)
//		public ModelAndView testingEmptyPage() {
//			try {
//				String message = "this message is being sent from within the test method";
//				
//				log.info("Finding user: -> {}",repo.findById(1000));
//				
//				model.addObject("messageToPass", message);
//				model.setViewName("test");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return model;
//		}
}