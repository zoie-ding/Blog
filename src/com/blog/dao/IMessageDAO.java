package com.blog.dao;

import java.util.List;

import com.blog.model.Message;

public interface IMessageDAO {
	//save message
	public void saveMessage(Message message);
	
	//update message
	public void updateMessage(Message message);
	
	//get all message
	public List<Message> getMessage();
	
	//delete message
	public void deleteMessage(String id, String userId);
	
	//get message according to id
	public Message getMessage(String id);
	
	//delete replyMessage according to id
	public void deleteReplyMessage(String id, String userId);
}
