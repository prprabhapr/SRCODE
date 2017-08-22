package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDAO;
import com.model.Category;
import com.model.User;

@Controller
public class CategoryController 
{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/addcategory")   //THIS IS FOR ADDING CATEGORY
	public ModelAndView addCategory()
	{
		return new ModelAndView("addCategory");
	}
	@ModelAttribute("category")       //THIS IS FOR ADDING CATEGORY
	public Category createCategory()
	{
		return new Category();
	}
	/*@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String insertUser(@Validated @ModelAttribute("user")User user,BindingResult result)*/
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST) //THIS IS FOR ADDING CATEGORY INSERTING VALUES INTO DB
	public String insertCategory(@Validated @ModelAttribute("category")Category category,BindingResult result)
	{
			if(result.hasErrors())
		{
			return "addCategory";
		}
			System.out.println(category.getId());
			System.out.println(category.getName());
			System.out.println(category.getDescription());
			categoryDAO.saveOrUpdate(category);
		return "addCategory";
	}
	/*@RequestMapping("/displaycategory")
	public String displaycategory()
	{
		return "displaycategory";
	}
	@RequestMapping(value="/manageCategory",method=RequestMethod.POST)
	public String displayCategory(@ModelAttribute("category")Category category,Model m1)
     {
	//m1.addAttribute("category",category);
	//m1.addAttribute("categoryList",categoryDAO.list());
	return "category";
     }*/
}
