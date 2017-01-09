package com.binovizer.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.binovizer.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
																		   		
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			factory = Persistence.createEntityManagerFactory("ifinances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Bank bank = em.find(Bank.class, 1L);
			System.out.println(em.contains(bank));
			em.remove(bank);
			System.out.println(em.contains(bank));
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			factory.close();
		}		
	}
}
