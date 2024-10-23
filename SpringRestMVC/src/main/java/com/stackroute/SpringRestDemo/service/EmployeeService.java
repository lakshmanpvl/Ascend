package com.stackroute.SpringRestDemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.SpringRestDemo.exception.EmployeeAlreadyExistsException;
import com.stackroute.SpringRestDemo.exception.EmployeeNotFoundException;
import com.stackroute.SpringRestDemo.model.Employee;
import com.stackroute.SpringRestDemo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository Erepo;
	
//	public EmployeeService()
//	{
//		
//	}
	
//	@Autowired
//	public EmployeeService(EmployeeRepository e)
//	{
//		this.Erepo=e;
//	}

	public Employee addEmployee(Employee emp)throws EmployeeAlreadyExistsException
	{
		//Optional<Employee> opt=this.Erepo.findById(emp.getId());
		//if(opt.isPresent()) {
		//	throw new EmployeeAlreadyExistsException();
	//	}
		//else {
		Erepo.save(emp);
		//}
		return emp;
	}
	public Employee getEmployeeById(int id)throws EmployeeNotFoundException
	{
		Employee emp=null;
		Optional<Employee> opt=this.Erepo.findById((long) id);
	
		if(opt.isPresent()) {
			emp=opt.get();
			
		}
		else
		
			throw new EmployeeNotFoundException();
		return emp;	
		
}
	
	
	public List getAllEmployees()
	{
		return Erepo.findAll();
	}
	

	public boolean deleteEmployee(int id)throws EmployeeNotFoundException{
		
	boolean status=false;
	Optional<Employee> opt=this.Erepo.findById((long) id);
	if(opt.isPresent()) {
		Employee emp=opt.get();
		Erepo.delete(emp);
		status=true;
		
	}
	else 
		throw new EmployeeNotFoundException();
		return status;	
			
}
	
	
	
	public Employee UpdateEmployee(int id)throws EmployeeNotFoundException{
		
		Employee emp=null;
	Optional<Employee> opt=this.Erepo.findById((long) id);
	if(opt.isPresent()) {
		 emp=opt.get();
		emp.setFirstname("U-Next");
		emp.setLastname("Bangalore");
		Erepo.save(emp);
		
		
	}
	else 
		throw new EmployeeNotFoundException();
		return emp;	
			
}
	}

