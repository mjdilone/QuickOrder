package com.ds.quickOrder.model;

public class Account {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String account_name;
	private String password;
	
	
	public Account() {
		
	}

	public Account(String account_name) {
		super();
		this.account_name = account_name;
	}
	public Account(int id, String fname, String lname, String email, String account_name, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.account_name = account_name;
		this.password = password;
	}
	
	public Account( String fname, String lname, String email, String account_name, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.account_name = account_name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", account_name="
				+ account_name + ", password=" + password + "]";
	}
}
