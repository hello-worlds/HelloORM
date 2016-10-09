package com.richasdy.HelloORM.Hibernate;

import java.util.Date;
import org.hibernate.Session;
import com.richasdy.HelloORM.Hibernate.model.Stock;
import com.richasdy.HelloORM.Hibernate.model.StockDetail;

public class HibernateOneToOne {
	public static void main(String[] args) {

		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Indonesia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		// double assignment for onetoone relation
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}

}
