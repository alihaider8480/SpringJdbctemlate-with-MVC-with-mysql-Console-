package com.employee.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.dao.EmployeeDAO;
import com.employee.pojo.EmployeePojo;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;         // if here i maked jdbctemplate reference variable and in that variable Dispatchers-servlet.xml automatically inject this refernce variable and i also defined connections so in other words
                                               // now we don't call and don't make dataSource variable then refernce variable because dataSource variable i defined jdbctemplate in xml.
	                                           // here we are using @Autowired its means run time jdbctemplate reference variable like this inject all xml dataSource those i defined xml like conection,url,password.if we are not use
	                                           // @Autowired so this variable can n't inject data of dataSource like connection.
											   // if we are not use @Autowired so next we use setter method of JdbcTemplate then use Constructor of this class and  then there make DataSource object and dataSource object we put jdbctemplate variable 
	                                           // like this example those i used commintted.
	
	/*public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);     // i don't use this Constructor because i used @Autowired Annotation
    }
    */
	
	@Override
	public void addemployee(EmployeePojo employeepojo) 
	{	
		jdbcTemplate.update("INSERT INTO employee_table(employee_name, salary,email, gender) VALUES (?,?,?,?)",employeepojo.getEmploeeName(),employeepojo.getSalary(),employeepojo.getEmail(),employeepojo.getGender());
	}

	@Override
	public void deleteemployee(EmployeePojo employeepojoobj) 
	{
	  jdbcTemplate.update("DELETE FROM employee_table WHERE employee_Id=?",employeepojoobj.getEmployeeId());	
	}

	@Override
	public void updateemployee(EmployeePojo employeepojoobj)
	{
	   jdbcTemplate.update("UPDATE employee_table set email=? WHERE employee_Id=?",employeepojoobj.getEmail(),employeepojoobj.getEmployeeId());	
	}

	@Override
	public List<EmployeePojo> getallrecords() 
	{
		 return  jdbcTemplate.query("select * From employee_table", new EmployeeRowMapper());
	}

	@Override
	public EmployeePojo getsingleid(int id) 
	{
		return jdbcTemplate.queryForObject("select * From employee_table WHERE employee_Id=?", new EmployeeRowMapper(), id);
	}

	
}
