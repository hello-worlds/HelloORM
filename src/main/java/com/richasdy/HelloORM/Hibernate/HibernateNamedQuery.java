package com.richasdy.HelloORM.Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.richasdy.HelloORM.Hibernate.model.HEmployee;

public class HibernateNamedQuery {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// named query with parameter
			// Query query = session.getNamedQuery("findEmployeeById")
			// .setParameter("id", 1);

			// native named query without parameter
			Query query = session.getNamedQuery("findAllEmployee");

			List employees = query.list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				HEmployee employee = (HEmployee) iterator.next();
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
