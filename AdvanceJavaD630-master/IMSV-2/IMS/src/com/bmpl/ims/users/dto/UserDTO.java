package com.bmpl.ims.users.dto;

import java.util.ArrayList;

public class UserDTO {
	private String userid;
	private String password;
	private String role;
	
	private ArrayList<RightDTO> rightList;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<RightDTO> getRightList() {
		return rightList;
	}
	public void setRightList(ArrayList<RightDTO> rightList) {
		this.rightList = rightList;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", password=" + password + ", role=" + role + ", rightList=" + rightList
				+ "]";
	}
	
	
	
}
