package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.Address;
import com.binovizer.data.entities.User;

public class Application {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		User user = new User();
		setUserFields(user);
		
		Address address = new Address();
		Address address2 = new Address();
		
		setAddressField(address);
		setAddressField2(address2);
		
		user.getAddress().add(address);
		user.getAddress().add(address2);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	private static void setUserFields(User user) {
		user.setFirstName("Mohd");
		user.setLastUpdatedBy("Mohd Nadeem");
		user.setLastName("Nadeem");
		user.setBirthDate(new Date());
		user.setCreatedBy("Mohd Nadeem");
		user.setCreatedDate(new Date());
		user.setLastUpdatedDate(new Date());
		user.setEmailAddress("mohd.nadeem3464@gmail.com");
	}

	private static void setAddressField2(Address address) {
		address.setAddressLine1("Line 1");
		address.setAddressLine2("Line 2");
		address.setCity("MuzaffarNagar");
		address.setState("UP");
		address.setZipCode("12345");
	}

	private static void setAddressField(Address address) {
		address.setAddressLine1("Line 3");
		address.setAddressLine2("Line 4");
		address.setCity("MuzaffarNagar");
		address.setState("UP");
		address.setZipCode("12345");
	}
}
