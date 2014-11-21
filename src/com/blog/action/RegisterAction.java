package com.blog.action;

import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IUserDAO;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private User user;
	private String repassword;
	
	public String execute() {
		User u = new User();
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		
		IUserDAO dao = (IUserDAO) DaoFactory.getDao("userDao");
		dao.saveUser(u);
		
		AuthorityUtil.saveUser(user);
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
