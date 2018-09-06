package com.employee.dao_impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.pojo.EmployeePojo;

public class EmployeeRowMapper  implements RowMapper<EmployeePojo>
{
	@Override
	public EmployeePojo mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
	    EmployeePojo obj = new EmployeePojo();
		obj.setEmployeeId(rs.getInt("employee_id"));
		obj.setEmploeeName(rs.getString("employee_name"));
		obj.setSalary(rs.getDouble("salary"));
		obj.setEmail(rs.getString("email"));
		obj.setGender(rs.getString("gender"));
		return obj;
	}	 
}
