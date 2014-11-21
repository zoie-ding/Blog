package com.blog.action;

import java.sql.Timestamp;

import com.blog.dao.DaoFactory;
import com.blog.dao.IMessageDAO;
import com.blog.model.Message;
import com.blog.model.ReplyMessage;
import com.opensymphony.xwork2.ActionSupport;

public class ReplySaveAction extends ActionSupport{
	private ReplyMessage reply;
		
		public String execute() {
			IMessageDAO dao = DaoFactory.getMessageDAO();
			Message message = dao.getMessage(reply.getMessage().getId());
			if(message != null) {
				ReplyMessage r = new ReplyMessage();
				r.setUsername(reply.getUsername());
				r.setTitle(reply.getTitle());
				r.setContent(reply.getContent());
				r.setPubdate(new Timestamp(System.currentTimeMillis()));
				
				r.setMessage(message);
				message.getReplies().add(r);
			} else{
				addActionMessage(getText("error.message.not.exist"));
			}
			return SUCCESS;
		}

		public ReplyMessage getReply() {
			return reply;
		}

		public void setReply(ReplyMessage reply) {
			this.reply = reply;
		}
		
		
}
