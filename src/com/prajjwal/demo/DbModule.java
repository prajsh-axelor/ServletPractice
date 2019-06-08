package com.prajjwal.demo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

public class DbModule extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
//		install(new ServletModule());
		
	}
	
	@Provides @Singleton
	public EntityManagerFactory provideEntityManagerFactory() {
	    Map<String, String> properties = new HashMap<String, String>();
	    properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/guice");
	    properties.put("javax.persistence.jdbc.user", "axelor");
	    properties.put("javax.persistence.jdbc.password", "axelor");
	    properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	    properties.put("eclipselink.logging.level", "FINE");
	    properties.put("eclipselink.ddl-generation", "create-tables");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    return Persistence.createEntityManagerFactory("Guice_JPA", properties);
	  }
	  
	  @Provides
	  public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	  }

}
