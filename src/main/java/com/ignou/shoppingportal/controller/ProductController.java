package com.ignou.shoppingportal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ignou.shoppingportal.model.Product;
import com.ignou.shoppingportal.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	// Create logger object
	 private static Logger logger = Logger.getLogger(ProductController.class);

	// For add product
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public boolean addProduct(@RequestBody Product product) {
		try {
			productService.addProduct(product);
		} catch (Exception e) {
			System.out.println("undefined error");
		}

		finally {
			return true;
		}
	}

	// For delete product by id
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public Product deleteProduct(@PathVariable("id") int productId) {
		Product product = productService.deleteProduct(productId);
		return product;
	}

	// For update product by id
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public boolean updateProduct(@RequestBody Product product, @PathVariable("id") int productId) {
		return productService.updateProduct(product, productId);
	}

	// For view product by id
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int productId) {
		return productService.getProduct(productId);
	}

	// For view all product
	@RequestMapping(value = "/allProduct", method = RequestMethod.GET)
	public List<Product> allProduct() {
		 logger.info("View all product");
		return productService.allProduct();
	}
}
