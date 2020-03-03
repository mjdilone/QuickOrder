package com.ds.quickOrder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.CheckoutServiceImpl;
import com.ds.quickOrder.service.HelperServiceImpl;

@Controller
public class CheckoutController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	private CheckoutServiceImpl checkoutService;
	
	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
	public ModelAndView checkout(
			@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
			@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString,	
			@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
			@RequestParam int id) {
		try {
			log.info("Method Entry " + new Object(){}.getClass().getEnclosingMethod().getName());
			log.info("Id in checkout is " + id); 
			log.info("User Id during checkout: " + cookieUserId);
			checkoutService.checkout(id);
			//checkoutService.sendCheckoutEmail(id);
			
			//need to clear out the cookies here for cartCount, might be why it's not working
			helper.prepModel(model, cartCountCookieString, cookieUsername, cookieUserId);
			model.setViewName("checkout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
