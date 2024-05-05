//package com.ibm.springboot.demo.controller;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ibm.springboot.demo.model.Employee;
//
//@RestController
//public class HelloController {
//	
//
//	@GetMapping("/hi")
//	public Employee getEmpById() {
//		return new Employee(101,"sonu",10.5);
//	}
//	
//	@GetMapping("/get-data")
//	public List<Employee> getAllEmp() {
//		List<Employee> empList = new ArrayList<>();
//		empList.addAll(Arrays.asList(new Employee(101,"monu",11.9),new Employee(102,"sonu",11.9),new Employee(103,"nonu",11.9)));
//		return empList;
// 	}
//	
//
//}
