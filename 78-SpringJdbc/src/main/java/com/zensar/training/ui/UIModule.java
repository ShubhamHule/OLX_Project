package com.zensar.training.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import com.zensar.training.bean.Employee;
import com.zensar.training.bean.Gender;
import com.zensar.training.service.EmployeeService;
import com.zensar.training.service.EmployeeServiceImpl;

public class UIModule {
	private static void blankLines(int num) {
		for (int i = 1; i <= num; i++)
			System.out.println();
	}

	public void addInfo() {
		blankLines(3);
		InputPrompter prompter = new InputPrompter();

		String name = prompter.promptForStringInput("Enter Name");
		char grade = prompter.promptForCharInput("Enter Grade[A,B,C]");
		LocalDate hiredDate = prompter.promptForDateInput("Enter DOJ", "dd-MMM-yyyy");
		double salary = prompter.promptForDoubleInput("Enter Basic Salary");
		Gender gender = prompter.promptForGenderInput("Enter Gender [1.MALE 2.FEMALE]");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setGrade(grade);
		employee.setHiredDate(hiredDate);
		employee.setBasicSalary(salary);
		employee.setGender(gender);

		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			boolean result = employeeService.addEmployee(employee);
			if (result == true)
				System.out.println("\t\t Added Successsfully");
			else
				System.out.println("Not Added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateInfo() {
		blankLines(3);
		InputPrompter prompter = new InputPrompter();

		int editableID = prompter.promptForIntInput("Enter ID to Update");
		String name = prompter.promptForStringInput("Enter Name");
		char grade = prompter.promptForCharInput("Enter Grade [A,B,C]");
		LocalDate hiredDate = prompter.promptForDateInput("Enter DOJ", "dd-MMM-yyyy");
		double salary = prompter.promptForDoubleInput("Enter Basic Salary");
		Gender gender = prompter.promptForGenderInput("Enter Gender [1.MALE 2.FEMALE]");

		Employee employee = new Employee();
		employee.setId(editableID);
		employee.setName(name);
		employee.setGrade(grade);
		employee.setHiredDate(hiredDate);
		employee.setBasicSalary(salary);
		employee.setGender(gender);

		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			boolean result = employeeService.updateEmployee(employee);
			if (result == true)
				System.out.println("\t\t Updated Successsfully");
			else
				System.out.println("Not Added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchInfo() {
		blankLines(3);
		InputPrompter prompter = new InputPrompter();
		int searchId = prompter.promptForIntInput("Enter ID to Search");

		Consumer<Employee> consumer = (e) -> {
			System.out.println("\t\t ID : " + e.getId());
			System.out.println("\t\t NAME : " + e.getName());
			System.out.println("\t\t DOJ : " + e.getHiredDate());
			System.out.println("\t\t SALARY : " + e.getBasicSalary());
			System.out.println("\t\t GRADE : " + e.getGrade());
			System.out.println("\t\t GENDER : " + e.getGender());

		};
		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			Employee employee = employeeService.findEmployee(searchId);
			if (employee == null) {
				System.out.println("\t\t Not found");
				return;

			}
			consumer.accept(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listInfo() {
		blankLines(3);

		EmployeeService employeeService = new EmployeeServiceImpl();

		Consumer<Employee> consumer = (e) -> {
			System.out.printf("%-5d", e.getId());
			System.out.printf("%-25s", e.getName());
			System.out.printf("%-15s", e.getHiredDate().toString());
			System.out.printf("%-15.2f", e.getBasicSalary());
			System.out.printf("%-5s", e.getGrade());
			System.out.printf("%-10s", e.getGender().toString());
			System.out.println();
		};
		List<Employee> employees = null;
		try {
			employees = employeeService.findAllEmployee();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		employees.stream().forEach(consumer);
	}

	public void deleteInfo() {
		blankLines(3);
		InputPrompter prompter = new InputPrompter();
		int searchId = prompter.promptForIntInput("Enter ID to Delete : ");

		EmployeeService employeeService = new EmployeeServiceImpl();

		boolean result = false;
		try {
			result = employeeService.deleteEmployee(new Employee(searchId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == true)
			System.out.println("\t\t Deleted Successfully");
		else
			System.out.println("\t\t Not Deleted");

	}
}
