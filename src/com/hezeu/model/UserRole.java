package com.hezeu.model;

public class UserRole {

	private Integer Id;
	private String RoleName;


	public Integer getId() {
		return this.Id;
	}


	public void setId( Integer id ) {
		this.Id = id;
	}


	public String getRoleName() {
		return this.RoleName;
	}


	public void setRoleName( String roleName ) {
		this.RoleName = roleName;
	}


	@Override
	public String toString() {
		return "UserRole [Id=" + this.Id + ", RoleName=" + this.RoleName + "]";
	}


}
