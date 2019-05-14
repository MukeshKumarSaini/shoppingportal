package com.ignou.shoppingportal.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignou.shoppingportal.model.User;

@Service
public class UserService {

	@Autowired
	EntityManager entityManager;

	public boolean addUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
	}

	public boolean updateUser(User user, int userId) {
		entityManager.getTransaction().begin();
		entityManager.find(User.class, userId);
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		return true;

	}

	public User getUser(int userId) {
		User user = null;
		entityManager.getTransaction().begin();
		user = entityManager.find(User.class, userId);
		entityManager.getTransaction().commit();
		return user;
	}

	public List<User> allUser() {
		entityManager.getTransaction().begin();
		List<User> user = new ArrayList<User>();
		user = entityManager.createQuery("select e from Category e").getResultList();
		entityManager.getTransaction().commit();
		return user;

	}

	public boolean deleteUser(int userId) {
		User user = null;
		entityManager.getTransaction().begin();
		user = entityManager.find(User.class, userId);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		return true;
	}

}
