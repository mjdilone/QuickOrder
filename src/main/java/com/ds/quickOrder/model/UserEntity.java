package com.ds.quickOrder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.quickOrder.Constants;

@Entity
@Table(name = Constants.TABLE_NAME_USERS)
public class UserEntity extends User{

	@Id
	private int id;
	@Column(name = "first_name")
	private String fname;
	@Column(name = "last_name")
	private String lname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String uname;
	
	public UserEntity() {
		
	}
	
	public UserEntity(String fname, String lname, String email, String password, String uname) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.uname = uname;
	}

	
	public UserEntity(User user) {
		super();
		this.fname = user.getFname();
		this.lname = user.getLname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.uname = user.getUname();
	}
	
	
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", uname=" + uname + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}