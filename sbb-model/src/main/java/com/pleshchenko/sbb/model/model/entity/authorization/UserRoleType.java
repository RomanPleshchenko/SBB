package com.pleshchenko.sbb.model.model.entity.authorization;

public enum UserRoleType {
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String UserRoleType;
	
	private UserRoleType(String userProfileType){
		this.UserRoleType = userProfileType;
	}
	
	public String getUserProfileType(){
		return UserRoleType;
	}
	
}
