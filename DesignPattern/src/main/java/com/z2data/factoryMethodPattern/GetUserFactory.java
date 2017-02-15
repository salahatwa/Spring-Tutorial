package com.z2data.factoryMethodPattern;

public class GetUserFactory {
	
	;

	/**
	 * Get User Using Factory Method Pattern
	 * 
	 * @param userType
	 * @return
	 */
	public User getUser(UserType userType) {
		User user = null;
		switch (userType) {
		case STUDENT:
			user = new Student();
			break;
		case TEACHER:
			user = new Teacher();
			break;

		default:
			break;
		}
		return user;
	}

}
