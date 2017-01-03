package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.TimeTest;

public class Application {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		TimeTest demo = new TimeTest(new Date());
		session.save(demo);
		session.getTransaction().commit();
		
		session.refresh(demo);
		System.out.println(demo);
		
		session.close();
		sf.close();
	}
}
