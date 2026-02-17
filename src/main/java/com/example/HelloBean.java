package com.example;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloBean implements Serializable{
	private String message;

	public HelloBean() {
		this.message = "Ejemplo bean";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String userList() {
		return "user-list";
	}
	public String getuserList() {
		return "user-list2";
	}
}
