package com.ignou.shoppingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ignou.shoppingportal.model.Category;
import com.ignou.shoppingportal.model.User;
import com.ignou.shoppingportal.services.CategoryService;
import com.ignou.shoppingportal.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	// For add user
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	// For delete user by id
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public boolean deleteUser(@PathVariable("id") int userId) {
		return userService.deleteUser(userId);
	}

	// For update user by id
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public boolean updateUser(@RequestBody User user, @PathVariable("id") int userId) {
		return userService.updateUser(user, userId);
	}

	// For view user by id
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}

	// For view all user
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<User> allUser() {
		return userService.allUser();
	}

}
