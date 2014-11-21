package com.blog.action;

import com.blog.auth.bean.UserInfo;
import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class MessageDeleteAction extends ActionSupport{
	private Message message;
	
	public String execute() {
		UserInfo user = AuthorityUtil.getUser();
		
		IMessageDAO dao = DaoFactory.getMessageDAO();
		dao.deleteMessage(message.getId(), user.getUserId());
		return SUCCESS;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
