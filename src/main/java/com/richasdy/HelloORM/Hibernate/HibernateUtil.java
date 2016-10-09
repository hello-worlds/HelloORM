package com.richasdy.HelloORM.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	// The SessionFactory is heavyweight object
	// so usually it is created during application start up and kept for later use.
	// You would need one SessionFactory object per database using a separate configuration file.
	// So if you are using multiple databases then
	// you would have to create multiple SessionFactory objects.

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			// AnnotationConfiguration Deprecated in Hibernate 3.6.
			// return new AnnotationConfiguration().configure().buildSessionFactory();
			return new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
