package com.richasdy.HelloORM.Hibernate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.richasdy.HelloORM.JPAEclipseLink.model.EREmployee;

@Entity
@Table(name = "hemployee")
public class HEmployee implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "salary")
	private int salary;
	

	public HEmployee() {
	}

	public HEmployee(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "HEmployee [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName
				+ ", salary=" + this.salary + "]";
	}
}
