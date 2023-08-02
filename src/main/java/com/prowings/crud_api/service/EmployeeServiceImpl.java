package com.prowings.crud_api.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.crud_api.entity.Employee;
import com.prowings.crud_api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
//		List<Employee> list = employeeRepository.findAll();
//		return list;
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmp_name()) && !"".equalsIgnoreCase(employee.getEmp_name())) 
            {
                originalEmployee.setEmp_name(employee.getEmp_name());
            }
           return employeeRepository.save(originalEmployee);
        }
        return null;
	}

	@Override
	public String deleteDepartmentById(Long id) {
		if(employeeRepository.findById(id).isPresent())
		{
			employeeRepository.deleteById(id);
			return "Employee Deleted Successfully";
		}
		return "No such employee present";
	}

}
