package com.bmpl.ims.users.dto;

public class TrainerDTO {
	String Name;
	String Address;
	String Fname;
	String Mail;
	String Phone;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String Mail) {
		this.Mail = Mail;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String fees) {
		this.Phone = Phone;
	}

	@Override
	public String toString() {
		return "TrainerDTO [Name=" + Name + ", Address=" + Address
				+ ", Phone=" + Phone + ", Mail=" + Mail + ", Fname=" + Fname + "]";
	}

}
