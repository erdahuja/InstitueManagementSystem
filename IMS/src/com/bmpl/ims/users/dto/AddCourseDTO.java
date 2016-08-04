package com.bmpl.ims.users.dto;

public class AddCourseDTO {
	String course_name;
	String course_description;
	String trainer_name;
	int duration;
	int fees;

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

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "AddCourseDTO [course_name=" + course_name + ", course_description=" + course_description
				+ ", trainer_name=" + trainer_name + ", duration=" + duration + ", fees=" + fees + "]";
	}

}
