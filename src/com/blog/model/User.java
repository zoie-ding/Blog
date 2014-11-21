package com.blog.model;

import java.util.Set;

public class User extends BaseModel {
	/*
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -689264623097552692L;
	
	private String name;
	private String password;
	private Set<Message> messages;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
	
}
