package com.ducla.TestPersistencePoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ducla.TestPersistencePoc.model.User;

@Repository
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Query query = entityManager.createQuery("from User");
		List<User> users = query.getResultList();
		return users;
	}

	/**
	 * Fetch Contacts entity by primary key
	 * 
	 * @param id
	 * @return
	 */
	public User get(String name) {
		return entityManager.find(User.class, name);
	}

	/**
	 * Create new contact entity
	 * 
	 * @param c
	 */
	public void create(User c) {
		entityManager.persist(c);
	}

	/**
	 * Update existing contact entity
	 * 
	 * @param c
	 */
	public void update(User c) {
		entityManager.merge(c);
	}

	/**
	 * Update existing contact entity
	 * 
	 * @param c
	 */
	public void delete(User c) {
		entityManager.remove(c);
	}
}