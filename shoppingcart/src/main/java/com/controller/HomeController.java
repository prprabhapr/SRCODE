package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserDAO;
import com.model.User;


@Controller //CONTROLLER ANNA 4 CLASS 
public class HomeController 
{
	@Autowired
	private UserDAO userDAO;
	   
	@RequestMapping("/")	//REQ-MAPPING ANNA 4 METHOD 
		public String index()
		{
			return "index";
		}
	@RequestMapping("/register")
	public String register()
	{
		return "register";
	}
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	@ModelAttribute("user")
	public User loginUser()
	{
		return new User();
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String insertUser(@Validated @ModelAttribute("user")User user,BindingResult result)
	{
			if(result.hasErrors())
		{
			return "register";
		}
		userDAO.saveUser(user);
		return "login";
	}
}	
