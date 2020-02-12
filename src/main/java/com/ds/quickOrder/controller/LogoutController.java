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
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.HelperServiceImpl;

@Controller
public class LogoutController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;

	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = {"/logout"},method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, 
	@CookieValue(value = "username",defaultValue = "emptyCookieUsername") String cookieUsername,
	@CookieValue(value = "password",defaultValue = "emptyCookiePassword") String cookiePassword,
	@CookieValue(value = "userId",defaultValue = "emptyCookieUserId") String cookieUserId,
	@CookieValue(value = "cartCountCookie",defaultValue = "emptyCookieCartCount") String cartCountCookieString){
		try {
			cookieUsername = "";
			cookiePassword = "";
			cookieUserId = "";
			cartCountCookieString = "";
			
			Cookie[] cookies = request.getCookies();
			if(cookies!=null)
			for (int i = 0; i < cookies.length; i++) {
			 cookies[i].setMaxAge(0);
			}
			
			Cookie cookieUsernameEmpty = new Cookie("username","");
			Cookie cookiePasswordEmpty = new Cookie("password","");
			Cookie cookieUserIdEmpty = new Cookie("userId","");
			Cookie cookieCartCountEmpty = new Cookie("cartCountCookie","");
			
			response.addCookie(cookieUsernameEmpty);
			response.addCookie(cookiePasswordEmpty);
			response.addCookie(cookieUserIdEmpty);
			response.addCookie(cookieCartCountEmpty);
			
			log.info("Values after logout ********");
			log.info(cartCountCookieString);
			log.info(cookieUsername);
			log.info(cookieUserId);
			log.info("********");
			//helper.prepModel(model, cartCountCookieString, cookieUsername, cookieUserId);
			model.addObject("username", "Guest");
			model.setViewName("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
}
