package com.z2data.factoryMethodPattern;

public class Teacher extends User{

	@Override
	public String setStage(String stageName) {
		LOGGER.info("success factory Teacher");
		return "Teacher teach in stage:"+stageName;
	}

}
