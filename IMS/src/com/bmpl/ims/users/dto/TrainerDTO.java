package com.bmpl.ims.users.dto;

import java.util.Date;

public class TrainerDTO {

	private String Trainer_Name;
	private int Trainer_Age;
	private String Trainer_Gender;
	private String Trainer_Address;
	private String Trainer_Mobileno;
	private String Trainer_Email;
	private String Trainer_Subject;
	private String Trainer_Image;
	private Date Trainer_Hire_Date;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainer_Name() {
		return Trainer_Name;
	}
	public void setTrainer_Name(String trainer_Name) {
		Trainer_Name = trainer_Name;
	}
	public int getTrainer_Age() {
		return Trainer_Age;
	}
	public void setTrainer_Age(int trainer_Age) {
		Trainer_Age = trainer_Age;
	}
	public String getTrainer_Gender() {
		return Trainer_Gender;
	}
	public void setTrainer_Gender(String trainer_Gender) {
		Trainer_Gender = trainer_Gender;
	}
	public String getTrainer_Address() {
		return Trainer_Address;
	}
	public void setTrainer_Address(String trainer_Address) {
		Trainer_Address = trainer_Address;
	}
	public String getTrainer_Mobileno() {
		return Trainer_Mobileno;
	}
	public void setTrainer_Mobileno(String trainer_Mobileno) {
		Trainer_Mobileno = trainer_Mobileno;
	}
	public String getTrainer_Email() {
		return Trainer_Email;
	}
	public void setTrainer_Email(String trainer_Email) {
		Trainer_Email = trainer_Email;
	}
	public String getTrainer_Subject() {
		return Trainer_Subject;
	}
	public void setTrainer_Subject(String trainer_Subject) {
		Trainer_Subject = trainer_Subject;
	}
	public String getTrainer_Image() {
		return Trainer_Image;
	}
	public void setTrainer_Image(String trainer_Image) {
		Trainer_Image = trainer_Image;
	}
	public Date getTrainer_Hire_Date() {
		return Trainer_Hire_Date;
	}
	public void setTrainer_Hire_Date(Date trainer_Hire_Date) {
		Trainer_Hire_Date = trainer_Hire_Date;
	}
	@Override
	public String toString() {
		return "TrainerDTO [Trainer_Name=" + Trainer_Name + ", Trainer_Age=" + Trainer_Age + ", Trainer_Gender="
				+ Trainer_Gender + ", Trainer_Address=" + Trainer_Address + ", Trainer_Mobileno=" + Trainer_Mobileno
				+ ", Trainer_Email=" + Trainer_Email + ", Trainer_Subject=" + Trainer_Subject + ", Trainer_Image="
				+ Trainer_Image + ", Trainer_Hire_Date=" + Trainer_Hire_Date + ", id=" + id + "]";
	}
	
	
}
