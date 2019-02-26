package com.ignou.shoppingportal.controller;

import java.io.File;
import java.util.List;

import org.apache.catalina.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ignou.shoppingportal.model.Product;
import com.ignou.shoppingportal.services.ProductService;

import sun.security.tools.keytool.Resources;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//Create logger object
	private static Logger logger = Logger.getLogger(ProductController.class);
	
	//For add product
	public boolean addProduct(@RequestBody Product product){	
		PropertyConfigurator.configure("log4j.properties");
		logger.info(logger);
		return productService.addProduct(product); 
		 }
	
	//For delete product by id
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public boolean deleteProduct(@PathVariable("id") int productId){
	 return productService.deleteProduct(productId);
	 }
	
	//For update product by id
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public boolean updateProduct(@RequestBody Product product,@PathVariable("id") int productId){
	 return productService.updateProduct(product,productId);
	 }
	//For view product by id
	@RequestMapping(value = "/getProduct/{id}",method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int productId){								
		return productService.getProduct(productId); 
       }
		
	//For view all product
	@RequestMapping(value = "/allProduct",method = RequestMethod.GET)
	public List<Product> allProduct(){		
		logger.info("View all product");
		return productService.allProduct(); 
	   }
	
}

