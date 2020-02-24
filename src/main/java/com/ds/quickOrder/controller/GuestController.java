package com.ds.quickOrder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.GuestServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GuestController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
		
	@Autowired
	private GuestServiceImpl guestService;
	
	ModelAndView model = new ModelAndView();
	
	//For testing
			@RequestMapping(value = {"/guestLogin"},method=RequestMethod.GET)
			public ModelAndView testing() {
				try {
					String message = "this message is being sent from within the test method but running the guest login";
					
					log.info("running guest login redirect");
					
					model.addObject("messageToPass", message);
					model.setViewName("test");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return model;
			}
			
	
}
