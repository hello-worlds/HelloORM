package com.richasdy.HelloORM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.richasdy.HelloORM.model.Employee;

public class JPAEmployeeCreate {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipselinkJPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEname("Gopal");
		employee.setSalary(40000);
		employee.setDeg("Technical Manager");

		Employee employee2 = new Employee();
		employee2.setEname("Gondol");
		employee2.setSalary(50000);
		employee2.setDeg("Manager");

		Employee employee3 = new Employee();
		employee3.setEname("Julian");
		employee3.setSalary(30000);
		employee3.setDeg("Asistant Technical Manager");

		
		entitymanager.persist(employee);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);
		
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
