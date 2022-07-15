package com.beanscope;

import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class HelloWorld {

	private String message;

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}

	public String getMessage() {
		return message;
//		System.out.println("Your Message: "+message);
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void draw() {
		System.out.println(this.getMessage());
	}
	

}
