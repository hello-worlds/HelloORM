package com.richasdy.HelloORM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.richasdy.HelloORM.model.ERDepartment;
import com.richasdy.HelloORM.model.EREmployee;

public class JPAERManyToOne {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipselinkJPAER");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		ERDepartment erdepartment = new ERDepartment();
		erdepartment.setName("Development");

		// Store Department
		entitymanager.persist(erdepartment);

		// Create Employee1 Entity
		EREmployee employee1 = new EREmployee();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");
		employee1.setERDepartment(erdepartment);

		// Create Employee2 Entity
		EREmployee employee2 = new EREmployee();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");
		employee2.setERDepartment(erdepartment);

		// Create Employee3 Entity
		EREmployee employee3 = new EREmployee();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");
		employee3.setERDepartment(erdepartment);

		// Store Employees
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
