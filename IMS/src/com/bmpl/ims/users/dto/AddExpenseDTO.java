package com.bmpl.ims.users.dto;

public class AddExpenseDTO {
	int capital_lease_cost;
	int advertising_cost;
	int broadband_cost;
	int staff_salary_cost;
	int maintainance_cost;
	int miscellaneous;
	public int getCapital_lease_cost() {
		return capital_lease_cost;
	}
	public void setCapital_lease_cost(int capital_lease_cost) {
		this.capital_lease_cost = capital_lease_cost;
	}
	public int getAdvertising_cost() {
		return advertising_cost;
	}
	public void setAdvertising_cost(int advertising_cost) {
		this.advertising_cost = advertising_cost;
	}
	public int getBroadband_cost() {
		return broadband_cost;
	}
	public void setBroadband_cost(int broadband_cost) {
		this.broadband_cost = broadband_cost;
	}
	public int getStaff_salary_cost() {
		return staff_salary_cost;
	}
	public void setStaff_salary_cost(int staff_salary_cost) {
		this.staff_salary_cost = staff_salary_cost;
	}
	public int getMaintainance_cost() {
		return maintainance_cost;
	}
	public void setMaintainance_cost(int maintainance_cost) {
		this.maintainance_cost = maintainance_cost;
	}
	public int getMiscellaneous() {
		return miscellaneous;
	}
	public void setMiscellaneous(int miscellaneous) {
		this.miscellaneous = miscellaneous;
	}
	@Override
	public String toString() {
		return "AddExpenseDTO [capital_lease_cost=" + capital_lease_cost + ", advertising_cost=" + advertising_cost
				+ ", broadband_cost=" + broadband_cost + ", staff_salary_cost=" + staff_salary_cost
				+ ", maintainance_cost=" + maintainance_cost + ", miscellaneous=" + miscellaneous + "]";
	}
	
	
}
