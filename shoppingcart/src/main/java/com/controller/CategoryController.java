package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDAO;
import com.model.Category;

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
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST) //THIS IS FOR ADDING CATEGORY INSERTING VALUES INTO DB
	public String insertCategory(@Validated @ModelAttribute("category")Category category,BindingResult result)
	{
			if(result.hasErrors())
		{
			return "addCategory";
	}
//			System.out.println(category.getId());
//			System.out.println(category.getName());
//			System.out.println(category.getDescription());
			categoryDAO.saveOrUpdate(category);
		return "addCategory";
	}
	@RequestMapping("/displaycat")
	public ModelAndView display()
	{
		ModelAndView m1=new ModelAndView("displayCategory");
		return m1;
	}
	@RequestMapping(value="/manageCategory",method=RequestMethod.GET)
	public ModelAndView displayCategory()
     {
		System.out.println("one");
		List<Category> list=categoryDAO.list();
		System.out.println("two");
		return new ModelAndView("displayCategory","list",list);
     }
}
