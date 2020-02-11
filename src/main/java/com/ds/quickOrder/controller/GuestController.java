package com.ds.quickOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ds.quickOrder.service.GuestServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GuestController {
	
	@Autowired
	private GuestServiceImpl guestService;
	
	ModelAndView model = new ModelAndView();
	
}
