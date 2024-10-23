package com.stackroute.SpringRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.SpringRestDemo.exception.EmployeeAlreadyExistsException;
import com.stackroute.SpringRestDemo.exception.EmployeeNotFoundException;
import com.stackroute.SpringRestDemo.model.Employee;
import com.stackroute.SpringRestDemo.service.EmployeeService;

@RestController
@RequestMapping("api/v1/restservice")
public class EmployeeController {

	@Autowired
	private EmployeeService Eserv;
	ResponseEntity<?> resentity;
	
//	@Autowired
//	public EmployeeController(EmployeeService eserv)
//	{
//		this.Eserv=eserv;
//	}
	
	
	@PostMapping("/addemployee")
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<?> addEmp(@RequestBody Employee emp)throws EmployeeAlreadyExistsException
	{
		System.out.println("before adding");
		try { Eserv.addEmployee(emp);
		System.out.println("after adding");
		resentity=new ResponseEntity<>(emp,HttpStatus.CREATED);
		}
		
		catch(EmployeeAlreadyExistsException e)
		{
			throw new EmployeeAlreadyExistsException();
			}
		catch(Exception e)
		{
			System.out.println(e);
		resentity=new ResponseEntity<>("Adding Failed,pls try later",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		return resentity;
		}
	
	
	
	@GetMapping("getEmployee/{eid}")
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> getEmp(@PathVariable("eid") int eid)throws EmployeeNotFoundException
	{
		try {

			System.out.println("beforegetting");
			
			Employee emp=Eserv.getEmployeeById(eid);
			System.out.println("after getting");
			resentity=new ResponseEntity<>(emp,HttpStatus.FOUND);
		}
		catch(EmployeeNotFoundException e)
		{
			throw new EmployeeNotFoundException();
			
			}
		catch(Exception e)
		{
			//throw new EmployeeNotFoundException();
			System.out.println(e);
			}
		return resentity;
	}
	
	@DeleteMapping("delEmployee/{eid}")
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> delemp(@PathVariable("eid") int id) throws EmployeeNotFoundException
			{
		try {
		Eserv.deleteEmployee(id);
		resentity=new ResponseEntity<>("employee deleted"+id,HttpStatus.OK);
		}
		catch(EmployeeNotFoundException e)
		{
			throw new EmployeeNotFoundException();
			
			}
		catch(Exception e)
		{
			//throw new EmployeeNotFoundException();
			System.out.println(e);
			}
		return resentity;
	}
	
	@RequestMapping("/getAllEmployees")
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<?> getEmp()
	{
		System.out.println("before adding");
		try { 
			List<Employee> list=Eserv.getAllEmployees();
		System.out.println("after adding");
		resentity=new ResponseEntity<>(list,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return resentity;
	}
	
	@PutMapping("updateEmployee/{eid}")
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> updateemp(@PathVariable("eid") int id) throws EmployeeNotFoundException
			{
		try {
		Employee emp=Eserv.UpdateEmployee(id);
		resentity=new ResponseEntity<>("employee status updated"+emp,HttpStatus.OK);
		}
		catch(EmployeeNotFoundException e)
		{
			throw new EmployeeNotFoundException();
			
			}
		catch(Exception e)
		{
			//throw new EmployeeNotFoundException();
			System.out.println(e);
			}
		return resentity;
	}
	
	
}

