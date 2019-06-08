package com.prajjwal.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Injector injector = Guice.createInjector(new DbModule());
	    InstructorDao instructorDao = injector.getInstance(InstructorDao.class);  
	    
	}

}
