package com.richasdy.HelloORM.Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.richasdy.HelloORM.Hibernate.model.HEmployee;
import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateQueryLanguage {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// SELECT QUERY
			// HQL SELECT with parameter binding
			// Query query = session.createQuery("FROM HEmployee where id =
			// :code");
			// query.setParameter("code", 1);

			// HQL SELECT with hardcode variable
			// query = session.createQuery("FROM HEmployee where id = '1'");

			// UPDATE QUERY
			// HQL UPDATE with parameter binding
			// Query query = session.createQuery("update HEmployee set
			// firstName= :firstName where id = :id");
			// query.setParameter("firstName", "Donni");
			// query.setParameter("id", 1);
			// int result = query.executeUpdate();
			// System.out.println("Number of item updated : " + result);

			// HQL UPDATE with hardcode variable
			// Query query = session.createQuery("update HEmployee set firstName
			// = 'Richasdy' where id = '1'");
			// int result = query.executeUpdate();
			// System.out.println("Number of item updated : " + result);

			// DELETE QUERY
			// HQL DELETE with parameter binding
			// Query query = session.createQuery("delete HEmployee where id =
			// :id");
			// query.setParameter("id", 11);
			// int result = query.executeUpdate();
			// System.out.println("Number of item deleted : " + result);

			// HQL DELETE with hardcode variable
			// Query query = session.createQuery("delete HEmployee where id =
			// '10'");
			// int result = query.executeUpdate();
			// System.out.println("Number of item deleted : " + result);

			// INSERT QUERY
			// In HQL, only the INSERT INTO … SELECT … is supported; there is no
			// INSERT INTO … VALUES.
			// HQL only support insert from another table.

			// PARAMETER BINDING
			// NAMED PARAMETERS
			// setParameter : auto discover the parameter data type
			// setString : parameter date type is String
			// setProperties : pass an object into the parameter binding

			// POSITION PARAMETER
			// Example
			// String hql = "from Stock s where s.stockCode = ? and s.stockName
			// = ?";
			// List result = session.createQuery(hql).setString(0,
			// "7277").setParameter(1, "DIALOG").list();

			// All result
			Query query = session.createQuery("FROM HEmployee");
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
