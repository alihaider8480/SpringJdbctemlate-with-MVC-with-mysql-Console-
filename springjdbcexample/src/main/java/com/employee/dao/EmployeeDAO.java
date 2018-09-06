package com.employee.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.pojo.EmployeePojo;

@Component
public interface EmployeeDAO 
{
	public void addemployee(EmployeePojo employeepojoobj);
	
	public void deleteemployee(EmployeePojo employeepojoobj);
	
	public void updateemployee(EmployeePojo employeepojoobj);
	
	public List<EmployeePojo> getallrecords();
	
	public EmployeePojo getsingleid(int id);
	
}
