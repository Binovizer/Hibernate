package com.binovizer.data;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		try {
			Bank bank = (Bank) session.get(Bank.class, 1L);
			bank.setName("Something Different");
			System.out.println("Calling Flush");
			session.flush();
			
			bank.setAddressLine1("Another Address Line");
			System.out.println("Calling commit");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
}
