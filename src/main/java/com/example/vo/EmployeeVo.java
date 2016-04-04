package com.example.vo;

import java.io.Serializable;

public class EmployeeVo implements Serializable {

	private static final long serialVersionUID = -6226887211560334133L;

	private int id;

	private String firstname;

	private String lastname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
