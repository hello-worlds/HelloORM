package com.richasdy.HelloORM.Hibernate;

import org.hibernate.Session;
import com.richasdy.HelloORM.Hibernate.HibernateUtil;
import com.richasdy.HelloORM.Hibernate.model.Stock;

public class HibernateApp {

	public static void main(String[] args) {
		System.out.println("CREATE");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Stock stock = new Stock();

		stock.setStockCode("4715a");
		stock.setStockName("GENMa");

		session.save(stock);
		session.getTransaction().commit();

		System.out.println(stock.toString());
	}

}
