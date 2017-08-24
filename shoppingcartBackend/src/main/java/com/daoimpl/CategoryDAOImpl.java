package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CategoryDAO;
import com.model.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{	
	@Autowired
	SessionFactory sessionFactory;
public	SessionFactory getSessionFactory()
{
	return sessionFactory;
}
public void setSessionFactory(SessionFactory sessionFactory) 
{
	this.sessionFactory =sessionFactory;
	
}
@Transactional
public boolean saveOrUpdate(Category category) 
{
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true ;
	}
	catch(HibernateException e) 
	{
		e.printStackTrace();
		return false; 
		
	}
}
@Transactional
public List<Category> list() 
{
	return sessionFactory.getCurrentSession().createQuery("from Category").list();
}

}