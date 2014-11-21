package com.blog.action;

import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class MessageUpdateAction extends ActionSupport{
	private Message message;
	
	public String execute() {
		IMessageDAO dao = DaoFactory.getMessageDAO();
		message = dao.getMessage(message.getId());
		if(message != null) {
			return SUCCESS;
		}
		
		addActionMessage(getText("error.message.not.exist"));
		
		return INPUT;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
}

