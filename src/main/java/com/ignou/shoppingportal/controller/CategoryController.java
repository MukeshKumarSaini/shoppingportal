package com.ignou.shoppingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ignou.shoppingportal.model.Category;
import com.ignou.shoppingportal.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// For add category
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public boolean addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	// For delete category by id
	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public boolean deleteCategory(@PathVariable("id") int categoryId) {
		return categoryService.deleteCategory(categoryId);
	}

	// For update category by id
	@RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.PUT)
	public boolean updateCategory(@RequestBody Category category, @PathVariable("id") int categoryId) {
		return categoryService.updateCategory(category, categoryId);
	}

	// For view category by id
	@RequestMapping(value = "/getCategory/{id}", method = RequestMethod.GET)
	public Category getCategory(@PathVariable("id") int categoryId) {
		return categoryService.getCategory(categoryId);
	}

	// For view all category
	@RequestMapping(value = "/allCategory", method = RequestMethod.GET)
	public List<Category> allCategory() {
		return categoryService.allCategory();
	}

}
