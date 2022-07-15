package com.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("This is java based Configuration");
		@SuppressWarnings("resource")
		
		/*ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld obj = (HelloWorld) context.getBean("helloworld");
		obj.setMessage("This is message");
		obj.getMessage();*/
		
		ApplicationContext cxt = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		((AbstractApplicationContext) cxt).registerShutdownHook();
		TextEditor te = (TextEditor) cxt.getBean(TextEditor.class);
		HelloWorld hw = (HelloWorld)cxt.getBean(HelloWorld.class);
		te.checkspell();
		hw.setMessage("I am imported in TextEditorConfig");
		hw.getMessage();
		HelloWorld hw2 = (HelloWorld)cxt.getBean(HelloWorld.class); //Created new context to check scope of bean
		hw2.getMessage();
		
//		((AbstractApplicationContext) cxt).close();

	}

}
