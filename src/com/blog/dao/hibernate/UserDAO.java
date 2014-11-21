package com.blog.dao.hibernate;

import com.blog.hibernate.HibernateDAO;
import com.blog.dao.IUserDAO;
import com.blog.exception.BlogDAOException;
import com.blog.model.User;

public class UserDAO extends HibernateDAO implements IUserDAO {

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		if(user == null) {
			return;
		}
		
		User u = getUser(user.getName());
		if(u != null) {
			throw new BlogDAOException("This userName has existed, please use other names.");
		}
		
		saveObject(user);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User u = (User) getObject("from User u where u.name = '" + username + "'");
		return u;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return (User) getObject(User.class, id);
	}

}
