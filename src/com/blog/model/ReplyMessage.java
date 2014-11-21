package com.blog.model;

import java.sql.Timestamp;
import java.util.Set;

public class ReplyMessage extends BaseModel {
	/*
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -1186059131975209652L;
	
	private String username;
	private String title;
	private String content;
	private Message message;
	private Timestamp pubdate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Timestamp getPubdate() {
		return pubdate;
	}
	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}
	
}
