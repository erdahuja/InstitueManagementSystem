package com.bmpl.ims.users.dto;

import java.util.ArrayList;

public class UserDTO {
	private String userid;
	private String password;
	private String role;
	private String coursename;
	private String trainername;
	
	private ArrayList<RightDTO> rightList;
	private ArrayList<CourseDTO> courseList;
	
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
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	public ArrayList<CourseDTO> getCourseList() {
		return courseList;
	}
	public void setCourseList(ArrayList<CourseDTO> courseList) {
		this.courseList = courseList;
	}
	
	
	
	
	
}
