package com.ds.quickOrder.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;
	
	ModelAndView model;
	
	@RequestMapping(value = {"/","login"},method=RequestMethod.GET)
	public ModelAndView login(HttpServletResponse response) {
		model = new ModelAndView();
				
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = {"/","login"},method=RequestMethod.POST)
	public ModelAndView loginAuth(@RequestParam String username,@RequestParam String password, HttpServletResponse response){
		model = new ModelAndView();
		Integer userId = loginService.retrieveAccountUserId(username);
		
		if(loginService.authenticateCredentials(username,password)) {
			Cookie cookieUsername = new Cookie("username",username);
			Cookie cookiePassword = new Cookie("password",password);
			Cookie cookieUserId = new Cookie("userId",userId.toString());
			
			response.addCookie(cookieUsername);
			response.addCookie(cookiePassword);
			response.addCookie(cookieUserId);
			
			model = new ModelAndView("redirect:/list");
		}else {
			model.setViewName("loginFailure");
		}
		
		return model;
	}		
}
