package com.stackroute.SpringRestDemo.service;


	import java.util.List;

	import com.stackroute.SpringRestDemo.exception.EmployeeAlreadyExistsException;
	import com.stackroute.SpringRestDemo.exception.EmployeeNotFoundException;
	import com.stackroute.SpringRestDemo.model.Employee;

	public interface IEmployeeService {
		public Employee addEmployee(Employee e)throws EmployeeAlreadyExistsException;
		public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
		public List<Employee>getAllEmployees();
		public Employee UpdateEmployee(int e)throws EmployeeNotFoundException;
		public boolean deleteEmployee(int id)throws EmployeeNotFoundException;

	}


