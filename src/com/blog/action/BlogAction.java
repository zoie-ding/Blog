package com.blog.action;

import com.blog.dao.DaoFactory;
import com.blog.dao.IUserDAO;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport{
	private User user;
	
	public String execute() {
		IUserDAO dao = DaoFactory.getUserDAO();
		user = dao.getUser(user.getName());
		if(user == null) {
			addActionMessage(getText("error.user.not.exist"));
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
