package com.binovizer.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
																		   		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			emf = Persistence.createEntityManagerFactory("ifinances");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Bank bank = em.find(Bank.class, 1L);
			em.detach(bank);
			System.out.println(em.contains(bank));
			
			bank.setName("Something else");
			Bank bank2 = em.merge(bank);
			
			bank2.setName("Something else 2");
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
		
	}
	
}
