package com.richasdy.HelloORM.Hibernate;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateViewStock {

	public static void main(String[] args) {

		HibernateViewStock ME = new HibernateViewStock();

		/* List down all the stocks */
		System.out.println("All Stocks");
		ME.listStocks();

		// application still active (un-terminate) if we dont shutdown
		 HibernateUtil.shutdown();

	}

	/* Method to READ all the stocks */
	public void listStocks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List stocks = session.createQuery("FROM Stock").list();
			for (Iterator iterator = stocks.iterator(); iterator.hasNext();) {
				Stock stock = (Stock) iterator.next();
				System.out.println(stock.toString());
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
