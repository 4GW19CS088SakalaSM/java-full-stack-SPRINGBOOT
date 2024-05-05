package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import com.ibm.springboot.demo.model.Employee;

public interface EmployeeService {

	public abstract Employee getEmployeeById(String employeeId);

	public abstract List<Employee> getAllEmployees();
	
	public abstract List<Employee> getEmployeeByFirstName(String firstName);

	public abstract Employee addEmployee(Employee employee);

	public abstract Optional<Employee> updateEmployee(String employeeId,Employee updatedEmployee);

	public abstract void deleteEmployee(String employeeId);

	public abstract Page<Employee> getEmployeePages(Integer page, Integer size, String sortBy);
}



//package com.ibm.springboot.demo.service;
//
//import java.util.List;
//
//import com.ibm.springboot.demo.model.Employee;
//
//public interface EmployeeService {
//
//	public abstract Employee getEmployeeById(Integer employeeId);
//
//	public abstract List<Employee> getAllEmployees();
//
//	public abstract Employee updateEmployee(Employee employee);
//
//	public abstract Employee deleteEmployee(Integer employeeId);
//}