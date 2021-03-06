package com.sample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.model.Employee;
import com.sample.app.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> all() {
		return ResponseEntity.ok(empRepo.all());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {
		Employee persistedEmp = empRepo.add(emp);

		return ResponseEntity.status(HttpStatus.CREATED).body(persistedEmp);

	}
}