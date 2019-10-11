package com.ds.quickOrder.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

@Controller
public class CartController {

	@Autowired
	CartServiceImpl cartService;
	
	ModelAndView model;
	
	@RequestMapping(value = {"/","addToCart"},method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam int id, @RequestParam int quantity,@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
			@CookieValue(value = "cookieHashUserId",defaultValue = "emptyCookieHashUserId") String cookieGuestUserId,
			HttpServletResponse response) {
		//needs to pass the id of the item that's been clicked on and the id of the current user
		Integer userId;
		System.out.println("User id from cookies is : " + cookieUserId);
		if(cookieUserId.equals("emptyCookieUserId")  ){
			Integer hashUserId = Constants.makeHashUserId();
			Cookie cookieHashUserId = new Cookie("cookieHashUserId",hashUserId.toString()); //creating new cookie for a Guest User Id
			
			//overwrite cookie
			Cookie cookieEmptyUserId = new Cookie("userId", hashUserId.toString());
			response.addCookie(cookieEmptyUserId);
			
			response.addCookie(cookieHashUserId);
			cookieUserId = hashUserId.toString();
			System.out.println("hash user id has been made " + hashUserId);
			
			//temporarily setting the value of the guestId cookie
			cookieGuestUserId = hashUserId.toString();
		}
		
		System.out.println("cookie for guest is " + cookieGuestUserId);
		if(!cookieGuestUserId.equals("emptyCookieHashUserId")) {
			System.out.println("calling the guest cart");
			//userId = (Integer)hashUserId;
			userId = Integer.valueOf(cookieGuestUserId);
			cartService.addToGuestCart(id, userId, quantity);
		}else {
			System.out.println("calling the cart");
			 userId = Integer.valueOf(cookieUserId);
			cartService.addToCart(id,userId,quantity);
		}
		
		System.out.println("User id before passing to cartService: " + userId);
		
//		model = new ModelAndView();
//		model.setViewName("next");
		model = new ModelAndView("redirect:/retrieveCart");
		return model;
	}
	/*
	 * TODO retrieving the cart has to work with guest ID values as well, the userId cookie has to be set when your setting a 
	 * guest cookie
	 */
	@RequestMapping (value = {"/","retrieveCart"},method=RequestMethod.GET)
	public ModelAndView retreiveCart(@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "password",defaultValue = "emptyCookiePassword") String cookiePassword,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId) {
		
		model = new ModelAndView();
		Integer userId = Integer.parseInt(cookieUserId);
		List<CartItem> cart;
		
		if(cookieUsername.equalsIgnoreCase("emptyCookieUsername")) {
			cart = cartService.retrieveGuestCart(userId);
		}else {
			 cart = cartService.retrieveCart(userId);
		}
		
		//System.out.println(cart.size());
		
		System.out.println("retrieving cookies in CartController");
		System.out.println(cookieUsername); //the cookie has been passed in the header and is now a simple value
		System.out.println(cookiePassword);
		System.out.println(cookieUserId);
		//cart = cartService.retrieveGuestCart(userId);
		model.addObject("cart",cart);
		model.setViewName("cart");
		return model;
	}
}