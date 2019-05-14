package com.ignou.shoppingportal.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ignou.shoppingportal.model.User;

public class LoginService {

	@Autowired
	EntityManager entityManager;

	public User checkLogin(String userName, String password) throws Exception {
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery(
				"SELECT e FROM User e WHERE e.userName = '" + userName + "' AND " + "e.password = '" + password + "'");
		User user = (User) query.getSingleResult();
		if (user == null) {
			throw new NoResultException();
		}

		entityManager.getTransaction().commit();
		return user;
	}
}
