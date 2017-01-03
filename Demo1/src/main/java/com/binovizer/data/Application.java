package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.User;

public class Application {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		User nad = new User();
		nad.setFirstName("Mohd");
		nad.setLastName("Nadeem");
		nad.setBirthDate(new Date());
		nad.setEmailAddress("mohd.nadeem3464@gmail.com");
		nad.setLastUpdatedBy("Mohd Nadeem");
		nad.setLastUpdatedDate(new Date());
		nad.setCreatedBy("Mohd Nadeem");
		nad.setCreatedDate(new Date());
		
		session.save(nad);
		sf.close();
	}
}
