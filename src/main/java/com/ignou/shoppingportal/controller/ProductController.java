package com.ignou.shoppingportal.controller;

import java.util.List;

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
	
	
	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public boolean addProduct(@RequestBody Product product){								
		return productService.addProduct(product); 
		 }
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public boolean deleteProduct(@PathVariable("id") int productId){
	 return productService.deleteProduct(productId);
	 }
	
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public boolean updateProduct(@RequestBody Product product,@PathVariable("id") int productId){
	 return productService.updateProduct(product,productId);
	 }
	
	@RequestMapping(value = "/getProduct/{id}",method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int productId){								
		return productService.getProduct(productId); 
       }
	
	@RequestMapping(value = "/allProduct",method = RequestMethod.GET)
	public List<Product> allProduct(Product product){								
		return productService.allProduct(); 
	   }
	
}

