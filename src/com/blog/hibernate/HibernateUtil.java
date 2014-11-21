package com.blog.hibernate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

@SuppressWarnings("deprecation")
public class HibernateUtil 
{

    private static Log log = LogFactory.getLog(HibernateUtil.class);

    // set NTERCEPTOR_CLASS
    private static final String INTERCEPTOR_CLASS = "hibernate.util.interceptor_class";

    // instance of static Configuration和SessionFactory, only one
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static 
    {
        // create SessionFactory
        try 
        {

            configuration = new Configuration();

            // get hibernate.cfg.xml
            configuration.configure();

            String interceptorName = configuration.getProperty(INTERCEPTOR_CLASS);
            if (interceptorName != null) 
            {
                Class interceptorClass =
                        HibernateUtil.class.getClassLoader().loadClass(interceptorName);
                Interceptor interceptor = (Interceptor)interceptorClass.newInstance();
                configuration.setInterceptor(interceptor);
            }

            if (configuration.getProperty(Environment.SESSION_FACTORY_NAME) != null) 
            {
                configuration.buildSessionFactory();
            } 
            else 
            {
                sessionFactory = configuration.buildSessionFactory();
            }

        } 
        catch (Throwable ex) 
        {
            // error information
            log.error("Building SessionFactory failed.", ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * 返回原始的Configuration对象的实例
     *
     * @return Configuration
     */
    public static Configuration getConfiguration() 
    {
        return configuration;
    }

    /**
     * 返回全局的SessionFactory对象的实例
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() 
    {
        SessionFactory sf = null;
        String sfName = configuration.getProperty(Environment.SESSION_FACTORY_NAME);
        if ( sfName != null) 
        {
            log.debug("Looking up SessionFactory in JNDI.");
            try 
            {
                sf = (SessionFactory) new InitialContext().lookup(sfName);
            } 
            catch (NamingException ex) 
            {
                throw new RuntimeException(ex);
            }
        } 
        else 
        {
            sf = sessionFactory;
        }
        if (sf == null)
            throw new IllegalStateException( "SessionFactory not available." );
        return sf;
    }

    /**
     * close SessionFactory, release resource
     */
    public static void shutdown() 
    {
        log.debug("Shutting down Hibernate.");
        // Close caches and connection pools
        getSessionFactory().close();

        // Clear static variables
        configuration = null;
        sessionFactory = null;
    }


    
     public static void rebuildSessionFactory() 
     {
        log.debug("Using current Configuration for rebuild.");
        rebuildSessionFactory(configuration);
     }

    
     public static void rebuildSessionFactory(Configuration cfg) 
     {
        log.debug("Rebuilding the SessionFactory from given Configuration.");
        synchronized(sessionFactory) 
        {
            if (sessionFactory != null && !sessionFactory.isClosed())
                sessionFactory.close();
            if (cfg.getProperty(Environment.SESSION_FACTORY_NAME) != null)
                cfg.buildSessionFactory();
            else
                sessionFactory = cfg.buildSessionFactory();
            configuration = cfg;
        }
     }

   
    public static SessionFactory registerInterceptorAndRebuild(Interceptor interceptor) 
    {
        log.debug("Setting new global Hibernate interceptor and restarting.");
        configuration.setInterceptor(interceptor);
        rebuildSessionFactory();
        return getSessionFactory();
    }
    
    public static Interceptor getInterceptor() 
    {
        return configuration.getInterceptor();
    }

    public static void commitAndBeginTransaction()
    {
    	sessionFactory.getCurrentSession().getTransaction().commit();
    	sessionFactory.getCurrentSession().beginTransaction();
    }
}

