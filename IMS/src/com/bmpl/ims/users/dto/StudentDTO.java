package com.bmpl.ojas.DTO;

public class StudentDTO {
	
	private String Name ;
	String course_name;
	String course_description;

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "StudentDTO [Name=" + Name + ", course_name=" + course_name + ", course_description="
				+ course_description + "]";
	}

	
}

