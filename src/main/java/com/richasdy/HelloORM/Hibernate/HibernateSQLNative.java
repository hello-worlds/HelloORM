package com.richasdy.HelloORM.Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.richasdy.HelloORM.Hibernate.model.HEmployee;

public class HibernateSQLNative {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			System.out.println("Return Class Array");
			// return HEmployee.class
			// Query query = session.createSQLQuery("select * from hemployee e
			// where e.id = :id")
			// .addEntity(HEmployee.class).setParameter("id", 1);

			// return you a HEmployee.class
			Query query = session.createSQLQuery("select * from hemployee").addEntity(HEmployee.class);

			List employees = query.list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				HEmployee employee = (HEmployee) iterator.next();
				System.out.println(employee.toString());
			}

			System.out.println("Return Object Array");
			// return Object array
			// query = session.createSQLQuery("select e.first_name from
			// hemployee e where e.id = :id")
			// .setParameter("id", 1);

			Query query2 = session.createSQLQuery("select first_name from hemployee");

			List employees2 = query2.list();
			
			// cant access when 2d object
			System.out.println(employees2.get(0).toString());
			
			for (Iterator iterator = employees2.iterator(); iterator.hasNext();) {
				Object employee = (Object) iterator.next();
				System.out.println(employee.toString());
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
