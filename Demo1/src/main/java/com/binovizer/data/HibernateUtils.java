package com.binovizer.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.binovizer.data.entities.User;

public class HibernateUtils {
	private static final SessionFactory sf = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(User.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
