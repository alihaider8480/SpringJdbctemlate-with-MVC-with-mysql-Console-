package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.dao_impl.EmployeeDAOImpl;
import com.employee.pojo.EmployeePojo;

@Controller
public class MainController 
{
	@Autowired
	private EmployeeDAOImpl employeedaoimpl;
	 
	@Autowired
	private EmployeePojo employeepojo;
	
	@RequestMapping("/")
	public String fun()
	{
		employeepojo.setEmploeeName("HaiderProgrammer");
		employeepojo.setSalary(100000.25);
		employeepojo.setEmail("alihaider8480@gmail.com");
		employeepojo.setGender("Male");
		
		employeedaoimpl.addemployee(employeepojo);
		return "index";
	}
	
	@RequestMapping("/delete")
	private String deleteemployeeby()
	{
		employeepojo.setEmployeeId(1);
		employeedaoimpl.deleteemployee(employeepojo);
		System.out.println("Deleted");
		return "index";
	}

	@RequestMapping("/update")
	private String updateemployee()
	{
		employeepojo.setEmail("AliHaider8480@Gmail.com");
		employeepojo.setEmployeeId(1);
		employeedaoimpl.updateemployee(employeepojo);
		System.out.println("Updated");
		return "index";
	}
	
	@RequestMapping("/show")
	public String showallrecord()
	{
		List<EmployeePojo> list1 =   employeedaoimpl.getallrecords();
		for(EmployeePojo employe: list1)
		{
			System.out.println(employe.getEmployeeId()+" "+employe.getEmploeeName()+" "+employe.getEmail()+" "+
		                       employe.getSalary()+" "+employe.getGender());
		}
		return "index";
	}
	
	
	@RequestMapping("/showsingle")
	public String showsinglerecord()
	{
		employeepojo = employeedaoimpl.getsingleid(1);
		System.out.println(employeepojo.getEmployeeId()+" "+employeepojo.getEmploeeName()+" "+employeepojo.getEmail()+" "+
				employeepojo.getSalary()+" "+employeepojo.getGender());
		return "index";
	}
}
