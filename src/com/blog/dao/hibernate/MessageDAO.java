package com.blog.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import com.blog.dao.IMessageDAO;
import com.blog.exception.BlogDAOException;
import com.blog.hibernate.HibernateDAO;
import com.blog.model.Message;
import com.blog.model.ReplyMessage;
import com.blog.model.User;

public class MessageDAO extends HibernateDAO implements IMessageDAO {

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		super.saveObject(message);
	}

	@Override
	public List<Message> getMessage() {
		// TODO Auto-generated method stub
		String hsql = "from Message";
		return (List<Message>)super.getObjects(hsql);
	}

	@Override
	public void deleteMessage(String id, String userId) {
		// TODO Auto-generated method stub
		User user = (User) getObject(User.class, userId);
		if(user == null) {
			throw new BlogDAOException("Couldn't user!");
		}
		Message m = null;
		Iterator<Message> it = user.getMessages().iterator();
		while(it.hasNext()) {
			Message message = (Message)it.next();
			if(message.getId().equals(id)) {
				m = message;
			}
		}
		
		if(m != null) {
			deleteObject(m);
			user.getMessages().remove(m);
		}else {
			throw new BlogDAOException("Can't find message or You don't have privilege to delete this message!");
		}
	}

	@Override
	public Message getMessage(String id) {
		// TODO Auto-generated method stub
		return (Message) getObject(Message.class, id);
	}
	
	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		updateObject(message);
	}

	@Override
	public void deleteReplyMessage(String id, String userId) {
		// TODO Auto-generated method stub
		ReplyMessage reply = (ReplyMessage) getObject(ReplyMessage.class, id);
		if(reply == null) {
			throw new BlogDAOException("Can't find the reply that you want to delete!");
		}
		
		Message message = reply.getMessage();
		Iterator<ReplyMessage> it = message.getReplies().iterator();
		while(it.hasNext()) {
			ReplyMessage r = (ReplyMessage) it.next();
			if(r.getId().equals(id)) {
				message.getReplies().remove(r);
			}
		}
	}

}
