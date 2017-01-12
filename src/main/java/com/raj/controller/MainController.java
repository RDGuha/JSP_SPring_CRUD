package com.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.dao.UserDAO;
import com.raj.model.User;

@Controller
public class MainController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Model model) {
		
		model.addAttribute("user", user );
		model.addAttribute("userList", this.userDAO.list());

		
		return "index";

	}
	
	@RequestMapping(value = "/user/view", method = RequestMethod.GET)
public String showview(Model model) {
		
		model.addAttribute("user", user );
		model.addAttribute("userList", this.userDAO.list());
		model.addAttribute("userview", true);

		
		return "index";

	}
	
	
	

}
