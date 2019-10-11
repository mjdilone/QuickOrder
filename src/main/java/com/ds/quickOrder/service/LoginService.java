package com.ds.quickOrder.service;

public interface LoginService {
	
	public Boolean authenticateCredentials(String username,String password);
	public Integer retrieveAccountUserId(String username);
	public Boolean userIsLoggedIn();
	
}
