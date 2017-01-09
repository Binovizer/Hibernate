package com.binovizer.data;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Bank bank = (Bank) session.load(Bank.class, 1L);
			System.out.println("Executed");
			System.out.println(bank.getName());
			
			
			/*Bank bank = (Bank) session.get(Bank.class, 1L);
			//Bank bank = (Bank) session.get(Bank.class, 123L);
			//bank = (Bank) session.get(Bank.class, 1L);
			System.out.println("Executed");
			System.out.println(bank.getName());*/
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
	
}
