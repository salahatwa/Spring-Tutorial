package com.z2data.factoryMethodPattern;



public class Student extends User {
	
	

	@Override
	public String setStage(String stageName) {
        LOGGER.info("success factory student");
		return "Student Stage:" + stageName;
	}

}
