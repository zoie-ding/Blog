package com.blog.config;

import java.util.Hashtable;

import org.apache.commons.lang.xwork.builder.ReflectionToStringBuilder;

import com.blog.exception.BlogException;

public class BlogConfig {
	public static Hashtable<String, DaoConfig> beans;
	
	//constructor
	public BlogConfig() {
		beans = new Hashtable<String, DaoConfig>();
	}
	
	public void addDao(DaoConfig bean) {
		beans.put(bean.getId(), bean);
	}
	
	public Object getDao(String name) {
		DaoConfig config = (DaoConfig) beans.get(name);
		
		if(config == null) {
			throw new BlogException("Couldn't find the dao:" + name);
		}
		
		return config.getInstance();
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
