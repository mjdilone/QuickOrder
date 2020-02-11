package com.ds.quickOrder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.controller.CartController;

@Service
public class HelperServiceImpl implements HelperService{
	
	@Autowired
	CartServiceImpl cartService;
	
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Override
	public void prepModel(ModelAndView model, String cartCountCookieString, String cookieUsername,String cookieUserId) {
		
		if(!cartCountCookieString.equalsIgnoreCase("emptyCookieCartCount")) {
			
			log.info("Method Entry " + new Object(){}.getClass().getEnclosingMethod().getName());
			log.info("CookieUserId: " + cookieUserId);
			
			int cartCount = (cartService.retrieveCart(Integer.parseInt(cookieUserId))).size();
			
			model.addObject("cartCount",cartCount);
			model.addObject("username",cookieUsername);
			model.addObject("id",cookieUserId);
		}else {
			int cartCount = (cartService.retrieveGuestCart(Integer.parseInt(cookieUserId))).size();

			model.addObject("username","Guest");
			model.addObject("cartCount",cartCount);
			
			
		}
	}
}
