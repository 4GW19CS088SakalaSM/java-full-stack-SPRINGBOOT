package com.ibm.springboot.demo.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Page<Employee> getEmployeePages(Integer page, Integer size, String sortBy) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return employeeRepository.findAll(pageable);
	}
	
	@Override
	public Employee getEmployeeById(String employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isEmpty()) {
			String errorMessage = "Employee with the id " + employeeId + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		} else
			return empOptional.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		LOG.info(firstName);
		List<Employee> empList = employeeRepository.findByFirstName(firstName);
		if (empList.isEmpty()) {
			String errorMessage = "Employee with firstName " + firstName + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return empList;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// any better code is needed?
		LOG.info(employee.toString());
		return employeeRepository.save(employee);
	}

	// @Override
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//		return empList;
//	}

//	@Override
//	public Employee addEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		empList.add(employee);
//		return employee;
//	}

	@Override
	 public Optional<Employee> updateEmployee(String employeeId, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setAadhar(updatedEmployee.getAadhar());

            return Optional.of(employeeRepository.save(existingEmployee));
        }
        return Optional.empty();
    }

	@Override
	public void deleteEmployee(String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }
		
	
	}


//package com.ibm.springboot.demo.service;
//
//import com.ibm.springboot.demo.model.Employee;
//import com.ibm.springboot.demo.repository.EmployeeRepository;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//	
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
//	
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//	
//	
//	
//    private final List<Employee> employees = new ArrayList<>();
//
//    public EmployeeServiceImpl() {
//    	
//        employees.add(new Employee(1, "John Doe", 50000.0));
//        employees.add(new Employee(2, "Jane Doe", 55000.0));
//    }
//
//    @Override
//    public Employee getEmployeeById(Integer employeeId) {
//    	LOG.info(employeeId.toString());
//    	LOG.warn(employeeId.toString());
//    	LOG.error(employeeId.toString());
//        return employees.stream()
//                .filter(employee -> employee.getEmployeeId().equals(employeeId))
//                .findFirst()
//                .orElse(null);
//    }
//    
//    @Override
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//		return employeeRepository.findAll();
//	}
//
////    @Override
////    public List<Employee> getAllEmployees() {
////        return new ArrayList<>(employees);
////    }
//
//    @Override
//    public Employee updateEmployee(Employee updatedEmployee) {
//        Employee employee = getEmployeeById(updatedEmployee.getEmployeeId());
//        if (employee != null) {
//            employee.setFirstName(updatedEmployee.getFirstName());
//            employee.setSalary(updatedEmployee.getSalary());
//            return employee;
//        }
//        return null; 
//    }
//
//    @Override
//    public Employee deleteEmployee(Integer employeeId) {
//        Employee employee = getEmployeeById(employeeId);
//        if (employee != null && employees.remove(employee)) {
//            return employee;
//        }
//        return null; 
//    }
//}
