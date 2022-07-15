package com.SpringDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TriangleConfig {
	
	@Bean
	public CStartEventHandler cStartEventHandler() {
		return new CStartEventHandler();
	}
	
	public CStopEventHandler cStopEventHandler() {
		return new CStopEventHandler();
	}
	
	@Bean
	@Scope("prototype")
	public Point point() {
		return new Point();
	}
	
	@Bean
	public Triangle triangle() {
		return new Triangle();
	}

}
