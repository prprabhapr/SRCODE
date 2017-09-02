package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDAO;
import com.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	 Category category;
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
	@RequestMapping(value="/manage_category_edit")
	public ModelAndView  editCategory(@RequestParam int id,Model model)
	{
		System.out.println("hello hi");
		Category category=categoryDAO.get(id);
		System.out.println("hello hi1");
		model.addAttribute("category",category);
		System.out.println("hello hi2");
		return new ModelAndView("updateCategory","category",category);
	}
	@RequestMapping(value="updateCat")
	public String updateCategory(@Valid @ModelAttribute("category")Category category,BindingResult result,Model model)
	{
		
			categoryDAO.updateCategory(category);
			return "forward:/manageCategory";
	}

	@RequestMapping(value="/manage_category_delete")
    public String deleteCategory(@RequestParam int id)
    {
		categoryDAO.deleteCategory(id);
		return "forward:/manageCategory";
    }
	
}
