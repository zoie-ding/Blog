package com.blog.action;

import com.blog.auth.bean.UserInfo;
import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IUserDAO;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class HomepageAction extends ActionSupport{
	private User user;
	
	public String execute() {
		UserInfo ui = AuthorityUtil.getUser();
		
		if(ui == null) {
			addActionError(getText("error.logon.first"));
			return INPUT;
		}
		
		IUserDAO dao = DaoFactory.getUserDAO();
		user = dao.getUserById(ui.getUserId());
		
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
