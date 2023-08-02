package com.prowings.crud_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.crud_api.entity.Employee;
import com.prowings.crud_api.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) throws Exception 
	{
		return empService.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee()
	{
		return empService.fetchAllEmployees();
	}
	
	@GetMapping("employee/{emp_id}")
	public Employee getEmployeeById(@PathVariable("emp_id") Long id)
	{
		return empService.getEmployeeById(id);
	}
	
	@PutMapping("/employee/{emp_id}")
	public Employee updateEmployee(@PathVariable("emp_id") Long emp_id , @RequestBody Employee employee)
	{
		return empService.updateEmployeeById(emp_id, employee);
	}
	
	@DeleteMapping("/employee/{emp_id}")
	public String deleteEmployee(@PathVariable("emp_id") Long id)
	{
		return empService.deleteDepartmentById(id);
	}

}
