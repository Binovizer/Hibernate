package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Bank bank = (Bank) session.get(Bank.class, 1L);
			
			bank.setName("Punjab National Bank");
			bank.setLastUpdatedBy("Mohd Nadeem");
			bank.setLastUpdatedDate(new Date());
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
	
}
