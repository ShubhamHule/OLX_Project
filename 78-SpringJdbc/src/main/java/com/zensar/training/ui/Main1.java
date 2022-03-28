package com.zensar.training.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zensar.training.bean.Employee;
import com.zensar.training.db.EmployeeSpringJdbcImpl;
import com.zensar.training.service.EmployeeServiceImpl;

public class Main1 {
	public static void main(String[] args) {
		while (true) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Employee employee = (Employee) context.getBean("employee");
			EmployeeSpringJdbcImpl jdbcImpl = (EmployeeSpringJdbcImpl) context.getBean("db");
			MenuHandler handler = new MenuHandler();
			handler.displayMenu();
		}
	}
}
