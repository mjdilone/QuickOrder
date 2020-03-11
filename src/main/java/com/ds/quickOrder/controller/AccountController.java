package com.ds.quickOrder.controller;

import java.util.List;

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

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.User;
import com.ds.quickOrder.service.AccountServiceImpl;
import com.ds.quickOrder.service.HelperServiceImpl;



@Controller
public class AccountController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	AccountServiceImpl accountService;
	
	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = {"/accountDetails"},method=RequestMethod.GET)
	public ModelAndView login(
	@RequestParam String username, HttpServletResponse response,
	@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString,
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId
) {
		try {
			Account account = accountService.retrieveAccount(username);
			
			log.info("Account name is " + account.getAccount_name());
			
			if(account.getAccount_name().equalsIgnoreCase("Guest")) {
				model.setViewName("guestLogin");
			}else {
				helper.prepModel(model, cartCountCookieString, cookieUsername,cookieUserId);
				model.addObject("account",account);
				model.setViewName("account");
			}
			
		} catch (Exception e) {
			log.info("Could not retrieve account Exception:" + e.toString());
		}
		return model;
	}	
	
	@RequestMapping(value = {"/pastOrders"},method=RequestMethod.GET)
	public ModelAndView pastOrders(
	@RequestParam int userId,
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "password",defaultValue = "emptyCookiePassword") String cookiePassword,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
	@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString,
	HttpServletResponse response) 
	{
		try {
			List<PastOrderItem> pastOrders = accountService.retrievePastOrders(userId);
			
			model.addObject("pastOrders",pastOrders);
			model.setViewName("pastOrders");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = {"/signUp"},method=RequestMethod.GET)
	public ModelAndView signUp(HttpServletResponse response, HttpServletResponse request) 
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.setViewName("signUpForm");
		return model;
	}
	
	@RequestMapping(value = {"/signUpNewUser"},method=RequestMethod.POST)
	public ModelAndView signUpNewUser(HttpServletResponse response, HttpServletResponse request,
		@RequestParam String fname,
		@RequestParam String lname,
		@RequestParam String uname,
		@RequestParam String password,
		@RequestParam String email) 
	{
		try {
			System.out.println("fname that's been passed in the sign up form: " + fname);
			System.out.println("lname that's been passed in the sign up form: " + lname);
			System.out.println("uname that's been passed in the sign up form: " + uname);
			System.out.println("password that's been passed in the sign up form: " + password);
			System.out.println("email that's been passed in the sign up form: " + email);

			User userToAdd = new User(fname,lname,email,password,uname);
			
			accountService.signUpNewUser(userToAdd);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.setViewName("signUpForm");
		return model;
	}
	
	
}