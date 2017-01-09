package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		try {
			Session session = HibernateUtils.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();			
			Bank detachedBank = (Bank) session.get(Bank.class, 1L);
			transaction.commit();
			session.close();
			
			Bank transientBank = createBank();
			
			Session session2 = HibernateUtils.getSessionFactory().openSession();
			org.hibernate.Transaction transaction2 = session2.beginTransaction();
						
			session2.saveOrUpdate(transientBank);
			session2.saveOrUpdate(detachedBank);
			detachedBank.setName("Test Bank 2");
			transaction2.commit();
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.getSessionFactory().close();
		}
	}

	private static Bank createBank() {
		Bank bank = new Bank();
		bank.setName("First United Federal");
		bank.setAddressLine1("103 Washington Plaza");
		bank.setAddressLine2("Suite 332");
		bank.setAddressType("PRIMARY");
		bank.setCity("New York");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipCode("10000");
		return bank;
	}

}
