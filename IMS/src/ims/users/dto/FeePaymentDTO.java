package com.bmpl.ims.users.dto;

import java.util.Date;

public class FeePaymentDTO {
	int AdmissionNum;
	String StudentName;
	String CourseName;
	int TotalFee;
	int Discount;
	int PayableAmount;
	int PaidAmount;
	int DueAmount;
	String date;
	String ModeofPayment;
	String ChequeNum;
	String BankName;
	public int getAdmissionNum() {
		return AdmissionNum;
	}
	public void setAdmissionNum(int admissionNum) {
		AdmissionNum = admissionNum;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getTotalFee() {
		return TotalFee;
	}
	public void setTotalFee(int totalFee) {
		TotalFee = totalFee;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getPayableAmount() {
		return PayableAmount;
	}
	public void setPayableAmount(int payableAmount) {
		PayableAmount = payableAmount;
	}
	public int getPaidAmount() {
		return PaidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		PaidAmount = paidAmount;
	}
	public int getDueAmount() {
		return DueAmount;
	}
	public void setDueAmount(int dueAmount) {
		DueAmount = dueAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public String getModeofPayment() {
		return ModeofPayment;
	}
	public void setModeofPayment(String modeofPayment) {
		ModeofPayment = modeofPayment;
	}
	public String getChequeNum() {
		return ChequeNum;
	}
	public void setChequeNum(String setChequeNum) {
		ChequeNum = setChequeNum;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	@Override
	public String toString() {
		return "FeePaymentDTO [AdmissionNum=" + AdmissionNum + ", StudentName=" + StudentName + ", CourseName="
				+ CourseName + ", TotalFee=" + TotalFee + ", Discount=" + Discount + ", PayableAmount=" + PayableAmount
				+ ", PaidAmount=" + PaidAmount + ", DueAmount=" + DueAmount + ", date=" + date + ", ModeofPayment="
				+ ModeofPayment + ", ChequeNum=" + ChequeNum + ", BankName=" + BankName + "]";
	}
	

}
