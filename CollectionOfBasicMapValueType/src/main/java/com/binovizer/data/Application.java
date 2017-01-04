package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.Bank;

public class Application {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Bank bank = new Bank();
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
		bank.getContacts().put("MANAGER","Nadeem");
		bank.getContacts().put("TELLER","Aayan");
		
		session.save(bank);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
