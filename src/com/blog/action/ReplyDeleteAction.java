package com.blog.action;

import com.blog.auth.bean.UserInfo;
import com.blog.auth.util.AuthorityUtil;
import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.model.ReplyMessage;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyDeleteAction extends ActionSupport{
private ReplyMessage reply;
	
	public String execute() {
		UserInfo user = AuthorityUtil.getUser();
		
		IMessageDAO dao = DaoFactory.getMessageDAO();
		dao.deleteReplyMessage(reply.getId(), user.getUserId());
		return SUCCESS;
	}

	public ReplyMessage getReply() {
		return reply;
	}

	public void setReply(ReplyMessage reply) {
		this.reply = reply;
	}
}
