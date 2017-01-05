package com.binovizer.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binovizer.data.entities.Credential;
import com.binovizer.data.entities.User;

public class Application {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		User user = new User();
		setUserFields(user);
		
		Credential credential = new Credential();
		credential.setUserName("Nidim");
		credential.setPassword("password");
		
		credential.setUser(user);
		user.setCredential(credential);
		
		session.save(credential);
		
		User dbUser = (User) session.get(User.class, credential.getUser().getUserId());
		System.out.println(dbUser.getFirstName());
		
		session.close();
		sf.close();
	}

	private static void setUserFields(User user) {
		user.setFirstName("Mohd");
		user.setLastUpdatedBy("Mohd Nadeem");
		user.setLastName("Nadeem");
		user.setBirthDate(new Date());
		user.setCreatedBy("Mohd Nadeem");
		user.setCreatedDate(new Date());
		user.setLastUpdatedDate(new Date());
		user.setEmailAddress("mohd.nadeem3464@gmail.com");
	}
}
