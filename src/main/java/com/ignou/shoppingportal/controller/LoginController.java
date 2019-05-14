package com.ignou.shoppingportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ignou.shoppingportal.model.User;
import com.ignou.shoppingportal.services.LoginService;

@RestController
@RequestMapping("/login")
@Scope("session")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(@RequestBody User user, HttpServletRequest request) throws Exception {
		User dbuser = loginService.checkLogin(user.getUserName(), user.getPassword());
		if (dbuser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", dbuser.getUserName());
			session.setAttribute("password", dbuser.getPassword());
			session.setMaxInactiveInterval(0);
			System.out.println(request.getSession().getId());
		}
			return "WELCOME" + "  " + dbuser.getUserName() + "  " + "YOUR ROLE ARE DEFINED  AS" + "  "
					+ dbuser.getRole() + "  mobile " + dbuser.getMobileNo();
		//return "invalid username or password";
		//login again
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "ACCOUNT LOGOUT SUCCESSFULLY";
	}

}
