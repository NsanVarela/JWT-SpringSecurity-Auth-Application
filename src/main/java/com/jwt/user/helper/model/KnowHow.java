package com.jwt.user.helper.model;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class KnowHow {
	
	private long id;
	private String name;
	private KnowHowCategory category;
	private KnowHowControl control;
	
	public KnowHow() { }
	
	public KnowHow(String name, KnowHowCategory category, KnowHowControl control) {
		this.name = name;
		this.category = category;
		this.control = control;
	}
	
}
