package com.stackroute.SpringRestDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYEE")

public class Employee {
	
	   

		@Id
	    @Column(name="EID")
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	 
	    @Column(name="FIRSTNAME")
	    private String firstname;
	 
	    @Column(name="LASTNAME")
	    private String lastname;
	 
	    @Column(name="EMAIL")
	    private String email;
	   
	    @Column(name="SALARY")
	    private int salary;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
		 @Override
			public String toString() {
				return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
						+ ", salary=" + salary + "]";
			}
	    
}
