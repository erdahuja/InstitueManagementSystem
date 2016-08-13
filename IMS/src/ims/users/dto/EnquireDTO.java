package com.bmpl.ims.users.dto;

public class EnquireDTO {
	private String firstName;
	private String secondName;
	private String mobileContact;
	private String otherContact;
	private String slot1;
	private String slot2;
	private String university;
	private String qualification;
	private String reference;
	private String fatherFirstName;
	private String fatherSecondName;
	private String fatherMobileContact;
	private String fatherOtherContact;
	private String address1;
	private String address2;
	private String email;
	private String coursename;	
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getSlot1() {
		return slot1;
	}
	public String getMobileContact() {
		return mobileContact;
	}
	public void setMobileContact(String mobileContact) {
		this.mobileContact = mobileContact;
	}
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}
	public String getFatherMobileContact() {
		return fatherMobileContact;
	}
	public String getFatherOtherContact() {
		return fatherOtherContact;
	}
	public void setFatherMobileContact(String fatherMobileContact) {
		this.fatherMobileContact = fatherMobileContact;
	}
	public void setFatherOtherContact(String fatherOtherContact) {
		this.fatherOtherContact = fatherOtherContact;
	}
	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}
	public String getSlot2() {
		return slot2;
	}
	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getFatherFirstName() {
		return fatherFirstName;
	}
	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	public String getFatherSecondName() {
		return fatherSecondName;
	}
	public void setFatherSecondName(String fatherSecondName) {
		this.fatherSecondName = fatherSecondName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EnquireDTO [firstName=" + firstName + ", secondName=" + secondName + ", mobileContact=" + mobileContact
				+ ", otherContact=" + otherContact + ", slot1=" + slot1 + ", slot2=" + slot2 + ", university="
				+ university + ", qualification=" + qualification + ", reference=" + reference + ", fatherFirstName="
				+ fatherFirstName + ", fatherSecondName=" + fatherSecondName + ", fatherMobileContact="
				+ fatherMobileContact + ", fatherOtherContact=" + fatherOtherContact + ", address1=" + address1
				+ ", address2=" + address2 + ", email=" + email + ", coursename=" + coursename + "]";
	}
	
	
	
	
}