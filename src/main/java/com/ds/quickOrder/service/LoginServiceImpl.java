package com.ds.quickOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.LoginDaoImpl;
import com.ds.quickOrder.model.Account;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaoImpl loginDao;
	
	@Override
	public Boolean authenticateCredentials(String username,String password) {
		Boolean flag = false;
		
		try {
			Account accountToVerify = loginDao.retrieveAccount(username);
			System.out.println("username  is: " + username + " "  );
			System.out.println("the account name and password from the DB are: " + accountToVerify.getAccount_name() + " " );
			
			if(accountToVerify.getAccount_name().toString().equals(username.trim()) && accountToVerify.getPassword().toString().equals(password)) {
				flag = true;
			}
			else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Integer retrieveAccountUserId(String username) {
		Account accountToRerieveId = new Account();
		Integer userId = null;
		try {
			accountToRerieveId = loginDao.retrieveAccount(username);
			userId = accountToRerieveId.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	//not used
	@Override
	public Boolean userIsLoggedIn() {
		return null;
	}

}
