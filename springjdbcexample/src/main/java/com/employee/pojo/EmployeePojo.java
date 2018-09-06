package com.employee.pojo;

import org.springframework.stereotype.Component;

@Component
public class EmployeePojo 
{
	private int employeeId;
	private String emploeeName;
	private String email;
	private Double salary;
	private String gender;
	public int getEmployeeId() {
		return employeeId; 
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmploeeName() {
		return emploeeName;
	}
	public void setEmploeeName(String emploeeName) {
		this.emploeeName = emploeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
