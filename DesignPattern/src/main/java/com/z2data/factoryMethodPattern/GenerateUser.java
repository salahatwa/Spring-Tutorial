package com.z2data.factoryMethodPattern;

public class GenerateUser {
	private static GetUserFactory getUserFactory=new GetUserFactory();
	
	public static void main(String[] args) {
       User user=getUserFactory.getUser(UserType.TEACHER);
       user.setStage("Primary Stage");
	}
}
