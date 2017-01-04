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
		user.setFirstName("Mohd");
		user.setLastName("Nadeem");
		user.setCreatedBy("Mohd Nadeem");
		user.setCreatedDate(new Date());
		user.setLastUpdatedBy("Mohd Nadeem");
		user.setLastUpdatedDate(new Date());
		user.setBirthDate(new Date());
		user.setEmailAddress("mohd.nadeem3464@gmail.com");
		
		Address address = new Address();
		address.setAddressLine1("Vill-Mustafabad");
		address.setAddressLine2("Po-Pachenda Kalan");
		address.setCity("Muzaffaranagar");
		address.setState("UP");
		address.setZipCode("12345");
		
		user.setAddress(address);
		session.save(user);
		
		/** DEMO 1 **/
		/*Bank bank = new Bank();
		bank.setName("PNB");
		bank.setAddressLine1("Mustafabad");
		bank.setAddressLine2("Pachenda Kalan");
		bank.setCity("Muzaffarnagar");
		bank.setState("UP");
		bank.setZipCode("25100");
		bank.setLastUpdatedBy("Mohd Nadeem");
		bank.setLastUpdatedDate(new Date());
		bank.setCreatedBy("Mohd Nadeem");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		session.save(bank);*/
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
