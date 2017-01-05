package com.binovizer.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import com.binovizer.data.entities.Account;
import com.binovizer.data.entities.Transaction;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Account account = createNewAccount();
			account.getTransactions().add(createNewBeltPurchase(account));
			account.getTransactions().add(createShoePurchase(account));
			session.save(account);
			
			transaction.commit();
			
			Transaction dbTransaction = (Transaction) session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
			System.out.println(dbTransaction.getAccount().getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtils.getSessionFactory().close();
		}
	}

	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Mohd Nadeem");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Mohd Nadeem");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Mohd Nadeem");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Mohd Nadeem");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Mohd Nadeem");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Mohd Nadeem");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
	
}
