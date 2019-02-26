package com.ignou.shoppingportal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignou.shoppingportal.controller.ProductController;
import com.ignou.shoppingportal.model.Product;

@Service
public class ProductService {
	@Autowired
	EntityManager entityManager;
	
	private static Logger logger = Logger.getLogger(ProductService.class);
	

	public boolean addProduct(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		/*
		 * entityManager.clear(); entityManager.close();
		 */
		return true;
	}

	public boolean updateProduct(Product product, int productId) {
		entityManager.getTransaction().begin();
		entityManager.find(Product.class, productId);
		entityManager.merge(product);
		entityManager.getTransaction().commit();
		return true;

	}

	public Product getProduct(int productId) {
		Product product = null;
		entityManager.getTransaction().begin();
		product = entityManager.find(Product.class, productId);
		  entityManager.getTransaction().commit();
		return product;
	}

	public List<Product> allProduct() {
		entityManager.getTransaction().begin();
		
		  List<Product> product=new ArrayList<Product>();
		  logger.info("Return all product");
		  product= entityManager.createQuery("select e from Product e").getResultList();
		  entityManager.getTransaction().commit();
		  return product;
		
		  
	}

	public boolean deleteProduct(int productId) {
		Product product = null;

		entityManager.getTransaction().begin();
		product = entityManager.find(Product.class, productId);
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		return true;
	}

}
