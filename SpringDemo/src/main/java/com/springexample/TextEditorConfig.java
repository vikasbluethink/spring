package com.springexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import (HelloWorldConfig.class)
public class TextEditorConfig {
	
	@Bean(initMethod="init", destroyMethod="cleanup")
	public TextEditor textEditor() {
		return new TextEditor(spellchecker());
	}
	
	@Bean
	public Spellchecker spellchecker() {
		return new Spellchecker();
	}

}
