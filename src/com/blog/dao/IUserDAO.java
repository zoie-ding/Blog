package com.blog.dao;

import com.blog.model.User;

/**
 * operate the DAO interface of the object - User
 * @author qianding
 *
 */
public interface IUserDAO {
	//save User
	public void saveUser(User user);
	
	//get userInfo according to userName to verify password when login
	public User getUser(String username);
	
	//get userInfo according to ID when user post messages
	public User getUserById(String id);
	
}
