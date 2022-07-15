package com.springexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfig {

	@Bean
	@Scope("prototype")
	public HelloWorld helloworld() {
		return new HelloWorld();
	}
}
