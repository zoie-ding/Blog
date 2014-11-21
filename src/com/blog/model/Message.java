package com.blog.model;

import java.sql.Timestamp;
import java.util.Set;

public class Message extends BaseModel {
	/*
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -4991231957346558770L;
	
	private String title;
	private String content;
	private User user;
	private Set<ReplyMessage> replies;
	private Timestamp pubdate;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<ReplyMessage> getReplies() {
		return replies;
	}
	public void setReplies(Set<ReplyMessage> replies) {
		this.replies = replies;
	}
	public Timestamp getPubdate() {
		return pubdate;
	}
	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}
	
	
}
