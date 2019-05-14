package com.ignou.shoppingportal.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignou.shoppingportal.model.Category;
import com.ignou.shoppingportal.model.Product;

@Service
public class CategoryService {

	@Autowired
	EntityManager entityManager;

	public boolean addCategory(Category category) {
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		/*
		 * entityManager.clear(); entityManager.close();
		 */
		return true;
	}

	public boolean updateCategory(Category category, int categoryId) {
		entityManager.getTransaction().begin();
		entityManager.find(Category.class, categoryId);
		entityManager.merge(category);
		entityManager.getTransaction().commit();
		return true;

	}

	public Category getCategory(int categoryId) {
		Category category = null;
		entityManager.getTransaction().begin();
		category = entityManager.find(Category.class, categoryId);
		entityManager.getTransaction().commit();
		return category;
	}

	public List<Category> allCategory() {
		entityManager.getTransaction().begin();
		List<Category> category = new ArrayList<Category>();
		category = entityManager.createQuery("select e from Category e").getResultList();
		entityManager.getTransaction().commit();
		return category;

	}

	public boolean deleteCategory(int categoryId) {
		Category category = null;
		entityManager.getTransaction().begin();
		category = entityManager.find(Category.class, categoryId);
		entityManager.remove(category);
		entityManager.getTransaction().commit();
		return true;
	}

}
