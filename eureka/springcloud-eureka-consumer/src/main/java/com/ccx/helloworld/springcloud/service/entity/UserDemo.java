package com.ccx.helloworld.springcloud.service.entity;

import java.io.Serializable;

public class UserDemo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDemo(String name, String password) {
		this.name=name;
		this.password=password;
	}
	
	public UserDemo() {
		super();
	}
	
	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "name: "+name+" password: "+password;
	}
	
}