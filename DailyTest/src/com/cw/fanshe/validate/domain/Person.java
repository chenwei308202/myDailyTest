package com.cw.fanshe.validate.domain;

public class Person {

	
	@Validate(notNull=true)
	private String name="";
	
	
	@Validate(notNull=true)
	private String age;
}
