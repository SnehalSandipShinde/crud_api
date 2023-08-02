package com.prowings.crud_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empl_Id;
	
	@Column
	String emp_name;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empl_Id, String emp_name) {
		super();
		this.empl_Id = empl_Id;
		this.emp_name = emp_name;
	}

	public Long getEmpl_Id() {
		return empl_Id;
	}

	public void setEmpl_Id(Long empl_Id) {
		this.empl_Id = empl_Id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
}
