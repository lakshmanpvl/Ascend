package com.example.SpringRestMVC;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stackroute.SpringRestDemo.model.Employee;
import com.stackroute.SpringRestDemo.repository.EmployeeRepository;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.stackroute.SpringRestDemo.model"})
@ComponentScan(basePackages={"com.stackroute.SpringRestDemo.model","com.stackroute.SpringRestDemo.controller",
	"com.stackroute.SpringRestDemo.exception","com.stackroute.SpringRestDemo.service","com.stackroute.SpringRestDemo.repository"})
@EnableJpaRepositories("com.stackroute.SpringRestDemo.repository")
//@ComponentScan(basePackages="com.stackroute.SpringRestDemo.controller")
public class SpringRestMvcApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringRestMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Employee obj=repo.findByFirstname("ben");
////		System.out.println(obj);
//Employee e=new Employee();
//e.setFirstname("Unext2");
//e.setLastname("Jigsaw2");
//e.setSalary(80000);
//e.setEmail("unext2@gmail");
//;		repo.save(e);
//System.out.println("finding by id from main");
//Optional<Employee> e5=repo.findById(1L);
//if(e5.isPresent())
//{
//	System.out.println("pls find ur emp details for empid:152 "+e5);
//}
//      Employee e= repo.findByfirstname("Unext1");
//      System.out.println(e);
//		java.util.List<Employee> e=repo.findByfirstnameContaining("ex");
//		System.out.println(e);
		
//		String str=repo.findFirstNameBasedOnEmailAddressSalaryWalmart("unext2@gmail",80000);
//		System.out.println(str);
//	Employee e2=	repo.findByEmailAddress("ruch1@gmail.com");
//	System.out.println(e2);
//repo.updateFirstNameBasedOnEmailwalmart("ken","unext2@gmail");
		
	}

}
