package com.zensar.training.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zensar.training.bean.Employee;
import com.zensar.training.db.DBConnectionFactory;
import com.zensar.training.db.EmployeeDAO;
import com.zensar.training.db.EmployeeSpringJdbcImpl;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public boolean addEmployee(Employee employee) throws Exception {

		boolean result = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		EmployeeDAO dao = new EmployeeSpringJdbcImpl();
		result = dao.addEmployee(jdbcTemplate, employee);
		return result;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws Exception {
		boolean result = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		EmployeeDAO dao = new EmployeeSpringJdbcImpl();
		result = dao.updateEmployee(jdbcTemplate, employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws Exception {

		boolean result = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		EmployeeDAO dao = new EmployeeSpringJdbcImpl();
		result = dao.deleteEmployee(jdbcTemplate, employee);
		return result;
	}

	@Override
	public Employee findEmployee(int id) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		EmployeeDAO dao = new EmployeeSpringJdbcImpl();
		Employee employee = dao.findEmployee(jdbcTemplate, id);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployee() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		EmployeeDAO dao = new EmployeeSpringJdbcImpl();
		return dao.findAllEmployees(jdbcTemplate);
	}

}
