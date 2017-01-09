package com.binovizer.data;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		try {
			Session session = HibernateUtils.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();			
			Bank bank = (Bank) session.get(Bank.class, 1L);
			transaction.commit();
			session.close();
			
			Session session2 = HibernateUtils.getSessionFactory().openSession();
			org.hibernate.Transaction transaction2 = session2.beginTransaction();
			
			System.out.println(session2.contains(bank));
			session2.update(bank);
			bank.setName("Test Bank");
			System.out.println("Method Invoked");
			System.out.println(session2.contains(bank));
			
			transaction2.commit();
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.getSessionFactory().close();
		}
	}
}
