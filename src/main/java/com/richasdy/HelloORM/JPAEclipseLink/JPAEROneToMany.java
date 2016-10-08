package com.richasdy.HelloORM.JPAEclipseLink;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.richasdy.HelloORM.model.ERDepartment;
import com.richasdy.HelloORM.model.EREmployee;

public class JPAEROneToMany {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipselinkJPAER");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Employee1 Entity
		EREmployee employee1 = new EREmployee();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");

		// Create Employee2 Entity
		EREmployee employee2 = new EREmployee();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");

		// Create Employee3 Entity
		EREmployee employee3 = new EREmployee();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");

		// Store Employee
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		// Create Employeelist
		List<EREmployee> emplist = new ArrayList();
		emplist.add(employee1);
		emplist.add(employee2);
		emplist.add(employee3);

		// Create Department Entity
		ERDepartment department = new ERDepartment();
		department.setName("Development");
		department.setEREmployeelist(emplist);

		// Store Department
		entitymanager.persist(department);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
