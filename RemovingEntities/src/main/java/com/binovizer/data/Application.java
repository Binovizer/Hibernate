package com.binovizer.data;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Bank bank = (Bank) session.get(Bank.class, 1L);
			session.contains(bank);
			System.out.println("Before Delete");
			session.delete(bank);
			System.out.println("After Delete");
			
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
	
}
