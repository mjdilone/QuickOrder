package com.ds.quickOrder.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.HelperServiceImpl;
import com.ds.quickOrder.service.LoginServiceImpl;
import com.ds.quickOrder.service.SaleItemServiceImpl;

@Controller
public class LoginController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private SaleItemServiceImpl saleItemService;
	
	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = {"/login"},method=RequestMethod.GET)
	public ModelAndView login(
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "password",defaultValue = "emptyCookiePassword") String cookiePassword,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
	@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString,
	@CookieValue(value = "cookieHashUserId",defaultValue = "emptyCookieHashUserId") String cookieGuestUserId,
	HttpServletResponse response,
	HttpServletRequest request) 
	{
		try {
			helper.prepModel(model, cartCountCookieString, cookieUsername, cookieUserId);
		} catch (Exception e) {
			model.addObject("username","Guest");
		}
		
		
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = {"/login"},method=RequestMethod.POST)
	public ModelAndView loginAuth(
	@RequestParam String username,
	@RequestParam String password, 
	HttpServletResponse response,
	HttpServletRequest request
	){
		
		if(username.isEmpty() || password.isEmpty()) {
			try {
				log.info("Login has failed");
				model.setViewName("loginFailure");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
		
		try {
			Integer userId = loginService.retrieveAccountUserId(username);

			if(loginService.authenticateCredentials(username,password)) {
				log.info("Logging in");
				try {
					Cookie cookieUsername = new Cookie("username",username);
					Cookie cookiePassword = new Cookie("password",password);
					Cookie cookieUserId = new Cookie("userId",userId.toString());
					
					int cartCount;
					if(username.equalsIgnoreCase("emptyCookieUsername")) {
						cartCount = saleItemService.retrieveCartCount(userId.toString(),true);
					} else {
						cartCount = saleItemService.retrieveCartCount(userId.toString(),false);
					}
					
					Cookie cookieCartCount = new Cookie("cartCountCookie", Integer.toString(cartCount));
					
					log.info("Username : " + cookieUsername);
					log.info("Password : " + cookiePassword);
					log.info("UserId : " + cookieUserId);
					log.info("CartCount : " + cookieCartCount);
					
					response.addCookie(cookieUsername);
					response.addCookie(cookiePassword);
					response.addCookie(cookieUserId);
					response.addCookie(cookieCartCount);
					
					model = new ModelAndView("redirect:/list");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					model.setViewName("loginFailure");
					log.info("Login has failed");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return model;
		} catch (Exception e) {
			model.setViewName("loginFailure");
			return model;
		}
	}		
}