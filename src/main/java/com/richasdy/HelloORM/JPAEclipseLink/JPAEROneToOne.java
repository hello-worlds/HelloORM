package com.richasdy.HelloORM.JPAEclipseLink;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.richasdy.HelloORM.JPAEclipseLink.model.ERDepartment;
import com.richasdy.HelloORM.JPAEclipseLink.model.EREmployee;

public class JPAEROneToOne {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipselinkJPAER");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		ERDepartment department = new ERDepartment();
		department.setName("Development");

		// Store Department
		entitymanager.persist(department);

		// Create Employee Entity
		EREmployee employee = new EREmployee();
		employee.setEname("Satish");
		employee.setSalary(45000.0);
		employee.setDeg("Technical Writer");
		employee.setERDepartment(department);

		// Store Employee
		entitymanager.persist(employee);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

}
