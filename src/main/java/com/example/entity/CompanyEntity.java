package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to EmployeeEntity
	@OneToMany(mappedBy="company")
	private List<EmployeeEntity> employees;

	public CompanyEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeEntity> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		getEmployees().add(employee);
		employee.setCompany(this);

		return employee;
	}

	public EmployeeEntity removeEmployee(EmployeeEntity employee) {
		getEmployees().remove(employee);
		employee.setCompany(null);

		return employee;
	}

}