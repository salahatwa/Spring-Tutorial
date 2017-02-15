package com.z2data.factoryMethodPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class User {
	
	private int id;
	private String name;
	private int age;
	public static Logger LOGGER = LoggerFactory.getLogger(Student.class);
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract String setStage(String stageName);
	
	
	@Override
	public String toString() {
		return "Name:"+name+"\t"+"Age:"+age;
	}

}
