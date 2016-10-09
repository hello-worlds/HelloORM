package com.richasdy.HelloORM.Hibernate;

import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateCRUDStock {

	public static void main(String[] args) {
		HibernateCRUDStock ME = new HibernateCRUDStock();

		/* Add few stock records in database */
		Integer stockID1 = ME.addStock("EB", "Eiger Bag");
		Integer stockID2 = ME.addStock("NS", "Nike Shoes");
		Integer stockID3 = ME.addStock("AP", "Apple Phone");

		/* List down all the stocks */
		System.out.println("Stock Before");
		ME.listStocks();

		/* Update stock records */
		ME.updateStock(stockID2, "Nike Running Shoes");

		/* Delete an employee from the database */
		ME.deleteStock(stockID3);

		/* List down new list of the employees */
		System.out.println("Stock After");
		ME.listStocks();

		// application still active (un-terminate) if we dont shutdown
		// HibernateUtil.shutdown();

	}

	/* Method to CREATE a stock in the database */
	public Integer addStock(String stockCode, String stockName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer stockId = null;
		try {
			tx = session.beginTransaction();
			Stock stock = new Stock(stockCode, stockName);
			stockId = (Integer) session.save(stock);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockId;
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

	/* Method to UPDATE stockName for an stock */
	public void updateStock(Integer stockId, String stockName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockId);
			stock.setStockName(stockName);
			session.update(stock);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE a stock from the records */
	public void deleteStock(Integer stockId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockId);
			session.delete(stock);
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
