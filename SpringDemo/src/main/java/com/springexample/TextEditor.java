package com.springexample;

public class TextEditor {
	
	private Spellchecker spellchecker;

	public TextEditor(Spellchecker spellchecker) {
		System.out.println("Inside TextEditor Constructor");
		this.spellchecker = spellchecker;
	}
	
	public void checkspell() {
		spellchecker.checkspelling();
	}
	
	public void init() {
		System.out.println("Bean is initialized.");
	}
	
	public void cleanup() {
		System.out.println("Bean is destroyed.");
	}
	

}