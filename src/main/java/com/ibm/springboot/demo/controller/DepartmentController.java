package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.service.DepartmentService;

@RestController
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("get-all-depts")
	public ResponseEntity<List<Department>> getAllEmps() {
		List<Department> deptList = departmentService.getAllDepartments();
		deptList.forEach(System.out::println);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All departments data fetched successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<List<Department>>(deptList, headers, status);
		return response;
	}
	
	@GetMapping("get-dept-by-id/{deptid}")
	public Department getDeptById( @PathVariable(name = "deptid") String departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		return department;
	}
	
	@PostMapping("add-dept")
	public ResponseEntity<Department> addDept(@RequestBody Department department) {
		Department deptToBeAdded = departmentService.addDepartment(department);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department added successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeAdded, headers, status);
		return response;
	}
	

}
