package com.bmpl.ims.users.dto;

public class TrainerDTO {

	private String trainer_name;
	private int trainer_age;
	private String trainer_gender;
	private String trainer_address;
	private String trainer_mobileno;
	private String trainer_email;
	private String trainer_subject;
	private String trainer_image;
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public int getTrainer_age() {
		return trainer_age;
	}
	public void setTrainer_age(int trainer_age) {
		this.trainer_age = trainer_age;
	}
	public String getTrainer_gender() {
		return trainer_gender;
	}
	public void setTrainer_gender(String trainer_gender) {
		this.trainer_gender = trainer_gender;
	}
	public String getTrainer_address() {
		return trainer_address;
	}
	public void setTrainer_address(String trainer_address) {
		this.trainer_address = trainer_address;
	}
	public String getTrainer_mobileno() {
		return trainer_mobileno;
	}
	public void setTrainer_mobileno(String trainer_mobileno) {
		this.trainer_mobileno = trainer_mobileno;
	}
	public String getTrainer_email() {
		return trainer_email;
	}
	public void setTrainer_email(String trainer_email) {
		this.trainer_email = trainer_email;
	}
	public String getTrainer_subject() {
		return trainer_subject;
	}
	public void setTrainer_subject(String trainer_subject) {
		this.trainer_subject = trainer_subject;
	}
	public String getTrainer_image() {
		return trainer_image;
	}
	public void setTrainer_image(String trainer_image) {
		this.trainer_image = trainer_image;
	}
	@Override
	public String toString() {
		return "TrainerDTO [trainer_name=" + trainer_name + ", trainer_age=" + trainer_age + ", trainer_gender="
				+ trainer_gender + ", trainer_address=" + trainer_address + ", trainer_mobileno=" + trainer_mobileno
				+ ", trainer_email=" + trainer_email + ", trainer_subject=" + trainer_subject + ", trainer_image="
				+ trainer_image + "]";
	}
	
	
}
