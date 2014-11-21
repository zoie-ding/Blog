package com.blog.action;

import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IUserDAO;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LogonAction extends ActionSupport{
	private User user = null;
	
	public String execute() {
		IUserDAO dao = DaoFactory.getUserDAO();
		User u = dao.getUser(user.getName());
		if(u != null && u.getPassword().equals(user.getPassword())) {
			AuthorityUtil.saveUser(u);
			return SUCCESS;
		}
		addActionError(getText("logon.failed"));
		return INPUT;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
