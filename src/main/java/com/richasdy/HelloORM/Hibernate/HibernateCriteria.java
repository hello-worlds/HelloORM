package com.richasdy.HelloORM.Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.richasdy.HelloORM.Hibernate.model.HEmployee;
import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateCriteria {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(HEmployee.class);
			criteria.addOrder(Order.asc("salary"));
			// criteria.add(Restrictions.eq("salary", 1000));
			// criteria.add(Restrictions.lt("salary", 1000));
			// criteria.add(Restrictions.gt("salary", 1000));
			// criteria.add(Restrictions.le("salary", 1000));
			// criteria.add(Restrictions.ge("salary", 1000));
			// criteria.add(Restrictions.like("firstName", "%on%"));
			// criteria.add(Restrictions.between("salary", 1000, 13000));
			// criteria.add(Restrictions.isNull("salary"));
			// criteria.add(Restrictions.isNotNull("salary"));

			// pagination with criteria
			// criteria.setMaxResults(5);
			// criteria.setFirstResult(2);

			// Query query = session.createQuery("FROM HEmployee");
			List employees = criteria.list();

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
