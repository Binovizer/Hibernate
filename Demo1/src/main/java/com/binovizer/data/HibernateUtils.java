package com.binovizer.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static final SessionFactory sf = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			        .configure( "hibernate.cfg.xml" )
			        .build();

			Metadata metadata = new MetadataSources( standardRegistry )
			        .getMetadataBuilder()
			        .build();

			return metadata.getSessionFactoryBuilder().build();
			/** Deprecated **/
			/*Configuration configuration = new Configuration();
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build());*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
