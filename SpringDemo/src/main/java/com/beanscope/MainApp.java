package com.beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/beanscope/config.xml");
		HelloWorld greet = (HelloWorld) context.getBean("message");
		greet.draw();
		System.out.println("Message: " + greet.getMessage());
		//System.out.println(greet);
		
		/*
		 * // greet.setMessage("Hello! I am from object 1 of singleton beanScope");
		 * greet.getMessage();
		 * 
		 * HelloWorld greet1 = (HelloWorld) context.getBean("messageBean"); //
		 * greet1.getMessage(); greet1.toString();
		 * 
		 * HelloWorld objA = (HelloWorld) context.getBean("helloworldprototype"); //
		 * objA.setMessage("Hello! I am from object 1 of prototype beanScope");
		 * objA.getMessage();
		 * 
		 * HelloWorld objB = (HelloWorld) context.getBean("helloworldprototype");
		 * objB.getMessage();
		 */
		
	}

}
