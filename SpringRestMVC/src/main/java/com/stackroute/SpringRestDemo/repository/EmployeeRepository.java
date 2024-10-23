package com.stackroute.SpringRestDemo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.stackroute.SpringRestDemo.model.Employee;

import jakarta.transaction.Transactional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	//public Employee findByfirstname(String str);
//	public List<Employee> findByFirstName(String nfirstName);
	//public List<Employee> findByfirstnameContaining(String name);
	@Query("select u.firstname from Employee u where u.email=?1 and u.salary=?2")
	public String findFirstNameBasedOnEmailAddressSalaryWalmart(String email,int sal);
//	@Modifying
//	@Transactional
//@Query(
	//	value="update employee set firstname=?1 where email=?2",nativeQuery=true)
//public int updateFirstNameBasedOnEmailwalmart(String firstName,String emailId);

}


