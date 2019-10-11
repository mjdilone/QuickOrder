package com.ds.quickOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/")
public class TestController {
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//	    return "index";
//	}
	
	   @RequestMapping(value = {"/"})
	    public String homePage() {
	        return "welcome";
	    }
}
