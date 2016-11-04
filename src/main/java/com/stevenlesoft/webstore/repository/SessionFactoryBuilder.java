/*
 * method object to configure and return a session factory
 */
package com.stevenlesoft.webstore.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {

	public static SessionFactory build()
	{
		SessionFactory sf = null;
		try{
			sf = new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
		
		return sf;
	}
}
