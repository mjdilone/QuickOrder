package com.ds.quickOrder.controller;

import java.util.List;

import javax.servlet.http.Cookie;
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

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.service.CartServiceImpl;
import com.ds.quickOrder.service.HelperServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	CartServiceImpl cartService;

	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = {"/addToCart"},method=RequestMethod.GET)
	public ModelAndView addToCart(
			@RequestParam int id,
			@RequestParam int quantity,
			@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
			@CookieValue(value = "cookieHashUserId",defaultValue = "emptyCookieHashUserId") String cookieGuestUserId,
			HttpServletResponse response) {
		
		log.info(this.getClass().getName(),"methodName");
		
		//needs to pass the id of the item that's been clicked on and the id of the current user
		Integer userId = null;
		log.info("User id from cookies is : " + cookieUserId);
		
		if(cookieUserId.equals("emptyCookieUserId")  ){
			try {
				Integer hashUserId = Constants.genGuestUserId();//create a random number for account number
				Cookie cookieHashUserId = new Cookie("cookieHashUserId",hashUserId.toString()); //creating new cookie for a Guest User Id
				
				//overwrite cookie
				Cookie cookieEmptyUserId = new Cookie("userId", hashUserId.toString());
				response.addCookie(cookieEmptyUserId);
				
				response.addCookie(cookieHashUserId);
				cookieUserId = hashUserId.toString();
				log.info("hash user id has been made " + hashUserId);
				
				//temporarily setting the value of the guestId cookie
				cookieGuestUserId = hashUserId.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		log.info("cookie for guest is " + cookieGuestUserId);
		if(!cookieGuestUserId.equals("emptyCookieHashUserId")) {
			try {
				log.info("calling the guest cart");
				userId = Integer.valueOf(cookieGuestUserId);
				cartService.addToGuestCart(id, userId, quantity);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}else {
			try {
				log.info("Calling the cart");
				userId = Integer.valueOf(cookieUserId);
				cartService.addToCart(id,userId,quantity);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		log.info("User id before passing to cartService: " + userId);
		model = new ModelAndView("redirect:/retrieveCart");
		return model;
	}
	
	@RequestMapping (value = {"/retrieveCart"},method=RequestMethod.GET)
	public ModelAndView retreiveCart(
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "password",defaultValue = "emptyCookiePassword") String cookiePassword,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
	@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString,	
	HttpServletResponse response) {
		
		Integer userId = null;
		
		if(cookieUserId.equalsIgnoreCase("emptyCookieUserId")  ){
			try {
				Integer hashUserId = Constants.genGuestUserId();//create a random number for account number
				Cookie cookieHashUserId = new Cookie("cookieHashUserId",hashUserId.toString()); //creating new cookie for a Guest User Id
				
				//overwrite cookie
				Cookie cookieEmptyUserId = new Cookie("userId", hashUserId.toString());
				response.addCookie(cookieEmptyUserId);
				
				response.addCookie(cookieHashUserId);
				cookieUserId = hashUserId.toString();
				log.info("hash user id has been made: " + hashUserId);
				
				//temporarily setting the value of the guestId cookie
				cookieUserId = hashUserId.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			 try {
				userId = Integer.parseInt(cookieUserId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		List<CartItem> cart = null;
		
		if(cookieUsername.equalsIgnoreCase("emptyCookieUsername")) {
			try {
				cart = cartService.retrieveGuestCart(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			 try {
				cart = cartService.retrieveCart(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			log.info("retrieving cookies in CartController");
			log.info("Method Entry " + new Object(){}.getClass().getEnclosingMethod().getName());
			log.info("Username: " + cookieUsername);
			log.info("Password: " + cookiePassword);
			log.info("User ID: " + cookieUserId);
			log.info("Cart Count: " + cartCountCookieString);
		
			helper.prepModel(model, cartCountCookieString, cookieUsername,cookieUserId);
			model.addObject("cart",cart);
			//model.addObject("id", cookieUserId);
			//model.addObject("username",cookieUsername);
			model.setViewName("cart");
		
		return model;
	}
}