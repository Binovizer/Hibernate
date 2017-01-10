package com.binovizer.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.Currency;
import com.binovizer.data.entities.ids.CurrencyId;

public class Application {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		Session session2 = null;
		org.hibernate.Transaction transaction2 = null;
		
		try {
			sf = HibernateUtils.getSessionFactory();
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			Currency inr = new Currency();
			inr.setName("INR");
			inr.setCountryName("India");
			inr.setSymbol("Indian Rupee");
			session.save(inr);

			transaction.commit();
			
			session2 = sf.openSession();
			transaction2 = session2.beginTransaction();
			Currency dbCurrency = (Currency) session2.get(Currency.class, new CurrencyId("INR","India"));
			System.out.println(dbCurrency.getSymbol());
			transaction2.commit();
			
		}catch (Exception e) {
			transaction.rollback();
			if (transaction2 != null) {
				transaction2.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
	
}
