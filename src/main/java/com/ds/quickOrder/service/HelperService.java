package com.ds.quickOrder.service;

import org.springframework.web.servlet.ModelAndView;

public interface HelperService {
	public void prepModel(ModelAndView model,String cartCountCookieString, String cookieUsername,String cookieUserId);
	
}
