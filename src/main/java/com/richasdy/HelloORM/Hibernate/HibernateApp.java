package com.richasdy.HelloORM.Hibernate;

import org.hibernate.Session;
import com.richasdy.HelloORM.Hibernate.HibernateUtil;
import com.richasdy.HelloORM.model.Stock;


public class HibernateApp {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Stock stock = new Stock();

		// stock.setStockCode("4715");
		// stock.setStockName("GENM");

		stock.setStockCode("4715a");
		stock.setStockName("GENMa");
		
		session.save(stock);
		session.getTransaction().commit();
	}

}
