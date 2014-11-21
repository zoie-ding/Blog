package com.blog.auth.util;

import java.util.Map;

import com.blog.auth.bean.UserInfo;
import com.blog.model.User;
import com.opensymphony.xwork2.ActionContext;

public class AuthorityUtil {
	public static final String SESSION_USERINFO = "authority.userinfo";
	
	public static void saveUser( User user) {
		if(user == null) return;
		
		UserInfo ui = getUser();
		
		if(ui == null){
			ui = new UserInfo();
		}
		
		ui.setUserId(user.getId());
		saveUser(ui);
	}
	
	public static void saveUser(UserInfo user) {
		Map session = ActionContext.getContext().getSession();
		session.put(SESSION_USERINFO, user);
	}
	
	public static UserInfo getUser() {
		Map session = ActionContext.getContext().getSession();
		return (UserInfo) session.get(SESSION_USERINFO);
	}
}
