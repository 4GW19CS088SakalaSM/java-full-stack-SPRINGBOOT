package com.ibm.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;
import com.ibm.springboot.demo.service.EmployeeService;

@SpringBootTest
class AppTests {


	
	private static final Logger LOG=LoggerFactory.getLogger(AppTests.class);
	@BeforeAll
	public static void setup() {
		LOG.info("before all");
	}
	@AfterAll
	public static void tearDown() {
		LOG.info("After all");
	}
	
	//@BeforeEach
	//@AfterEach
		
		@Autowired
		private EmployeeService employeeService;

		@Test
		public void getAllEmps() {
			assertEquals(employeeService.getAllEmployees().size(),14);
		}
		
		@Test
		public void getAllEmps2() {
			assertEquals(employeeService.getAllEmployees().size(),15);
		}
		
//		@Test
//		public void getAddEmp() {
//			Employee employee= new Employee("qqq","test data",,9876873872,"fhgyttt",797);
//			assertEquals(employeeService.addEmployee(employee),employee);
//		}

}

//assertEquals to check whether the actual output is same as expected o/p
