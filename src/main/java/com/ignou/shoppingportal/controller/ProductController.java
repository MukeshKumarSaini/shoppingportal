package com.ignou.shoppingportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	@ResponseBody
	public String getProduct(){
		return "Spring mvc Apllication project 111";

	
		
	}

}

