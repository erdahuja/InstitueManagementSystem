package com.bmpl.ims.users.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeAttendanceDTO {
	
	private String batchname;
	private List<String> student;
	private Date date;
	private Date startdate;
	private Date enddate;
	private String selectedstudent;
	public String getSelectedstudent() {
		return selectedstudent;
	}
	public void setSelectedstudent(String selectedstudent) {
		this.selectedstudent = selectedstudent;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public List<String> getStudent() {
		return student;
	}
	public void setStudent(List<String> student) {
		this.student = student;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
