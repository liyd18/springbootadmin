package com.wht.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class User implements Serializable{

	/**
	 * <p>TODO</br>
	 * @author liyd
	 * @version 2017年11月24日
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Value("${admin.username}")
	private String username;
	@Value("${admin.password}")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
