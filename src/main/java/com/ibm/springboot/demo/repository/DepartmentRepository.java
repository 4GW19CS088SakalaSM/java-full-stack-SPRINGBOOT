package com.ibm.springboot.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.springboot.demo.model.Department;

public interface DepartmentRepository extends MongoRepository<Department,String> {
	
	public abstract Department findByDepartmentId(String departmentId);

}
