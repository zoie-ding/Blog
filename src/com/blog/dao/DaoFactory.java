package com.blog.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import com.blog.config.BlogConfig;

public class DaoFactory {
	
	private static Log log = LogFactory.getLog(DaoFactory.class);

	public static final BlogConfig blogConfig;
	
	static
	{
		Digester digester = new Digester();
		digester.setValidating( false );
		
		digester.addObjectCreate( "config", 
		    "cn.hxex.blog.config.BlogConfig" );
		digester.addSetProperties( "config" );
		
		digester.addObjectCreate( "config/dao", 
		    "cn.hxex.blog.config.DaoConfig" );
		digester.addSetProperties( "config/dao" );
		digester.addSetNext( "config/dao", "addDao", 
		    "cn.hxex.blog.config.DaoConfig" );
		
		ClassLoader classLoader = 
		    Thread.currentThread().getContextClassLoader();
		InputStream in = 
		    classLoader.getResourceAsStream( "BlogConfig.xml" );
		BlogConfig config = null;
		try 
		{
			if( in!=null )
				config = (BlogConfig)digester.parse( in );
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (SAXException e) 
		{
			e.printStackTrace();
		}
		blogConfig = config;
	}
	
	// get DAO object
	public static Object getDao( String name )
	{
		if( null==blogConfig ) return null;
		
		if( log.isInfoEnabled() ) {
			log.info( "Getting the dao:" + name );
		}
		
		return blogConfig.getDao( name );
	}
	
	public static IUserDAO getUserDAO() {
		log.info( "Getting the userDao..." );
		return (IUserDAO)getDao( "userDao" );
	}

	public static IMessageDAO getMessageDAO() {
		log.info( "Getting the messageDao..." );
		return (IMessageDAO)getDao( "messageDao" );
	}
}

