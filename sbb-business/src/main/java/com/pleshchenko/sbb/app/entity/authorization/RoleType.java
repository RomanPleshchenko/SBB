package com.pleshchenko.sbb.app.entity.authorization;

import java.io.Serializable;

public enum RoleType implements Serializable{
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	private String roleType;
	
	private RoleType(String roleType){
		this.roleType = roleType;
	}
	
	public String getRoleType(){
		return roleType;
	}
	
}
