package com.richasdy.HelloORM.Hibernate;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateStockService {

	private static SessionFactory factory;

	/* Method to CREATE an stock in the database */
	public Integer addStock(String stockCode, String stockName) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer stockID = null;
		try {
			tx = session.beginTransaction();
			Stock stock = new Stock(stockCode, stockName);
			stockID = (Integer) session.save(stock);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockID;
	}

	/* Method to READ all the Stocks */
	public void listStocks() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List stocks = session.createQuery("FROM Stock").list();
			for (Iterator iterator = stocks.iterator(); iterator.hasNext();) {
				Stock stock = (Stock) iterator.next();
				System.out.print("Stock Id: " + stock.getStockId());
				System.out.print("Stock Code: " + stock.getStockCode());
				System.out.println("Stock Name: " + stock.getStockName());
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

	/* Method to UPDATE stockName for a Stock */
	public void updateStock(Integer stockID, String stockName) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockID);
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
	public void deleteStock(Integer stockID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockID);
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
