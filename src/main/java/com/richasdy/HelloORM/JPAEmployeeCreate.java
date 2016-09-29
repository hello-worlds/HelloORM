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

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
