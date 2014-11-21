package com.blog.action;

import java.sql.Timestamp;

import com.blog.auth.bean.UserInfo;
import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.dao.IUserDAO;
import com.blog.model.Message;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionSupport;


public class MessageSaveAction extends ActionSupport {
	private Message message;
	
	public String execute() {
		message.setPubdate(new Timestamp(System.currentTimeMillis()));
		
		UserInfo ui = AuthorityUtil.getUser();
		IUserDAO userDao = DaoFactory.getUserDAO();
		User user = userDao.getUserById(ui.getUserId());
		message.setUser(user);
		
		IMessageDAO dao = DaoFactory.getMessageDAO();
		dao.saveMessage(message);
		
		user.getMessages().add(message);
		
		addActionMessage(getText("message.save.success"));
		
		return SUCCESS;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
}
