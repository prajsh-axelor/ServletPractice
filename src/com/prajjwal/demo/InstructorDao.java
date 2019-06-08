package com.prajjwal.demo;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class InstructorDao {
	
	protected EntityManager entityManager;
	
	@Inject 
	public InstructorDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void save(Instructor instructor) {
		entityManager.getTransaction().begin();
		entityManager.persist(instructor);
		entityManager.getTransaction().commit();
	}

}
