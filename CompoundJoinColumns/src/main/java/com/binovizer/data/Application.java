package com.binovizer.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.Currency;
import com.binovizer.data.entities.Market;

public class Application {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		org.hibernate.Transaction transaction2 = null;
		
		try {
			sf = HibernateUtils.getSessionFactory();
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			Currency inr = new Currency();
			inr.setName("Dinar");
			inr.setCountryName("Quwait");
			inr.setSymbol("Quwait Dinar");
			
			Market market = new Market();
			market.setMarketName("Quwait Stock Exchange");
			market.setCurrency(inr);
			session.save(market);

			transaction.commit();
			
			transaction2 = session.beginTransaction();
			Market dbMarket = (Market) session.get(Market.class, 13L);
			dbMarket.setMarketName("Quwait Stock Exchange");
			
			transaction2.commit();
			
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}
	
}
