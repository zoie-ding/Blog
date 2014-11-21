package com.blog.action;

import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class MessageSaveUpdateAction extends ActionSupport{
	private Message message;
	
	public String execute() {
		IMessageDAO dao = DaoFactory.getMessageDAO();
		Message m = dao.getMessage(message.getId());
		if(m != null) {
			m.setTitle(message.getTitle());
			m.setContent(message.getContent());
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
