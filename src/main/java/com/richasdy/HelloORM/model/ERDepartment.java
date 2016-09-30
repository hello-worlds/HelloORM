package com.richasdy.HelloORM.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ERDepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;

	@OneToMany(targetEntity = EREmployee.class)
	private List eremployeelist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String deptName) {
		this.name = deptName;
	}

	public List getEREmployeelist() {
		return eremployeelist;
	}

	public void setEREmployeelist(List employeelist) {
		this.eremployeelist = employeelist;
	}
}
