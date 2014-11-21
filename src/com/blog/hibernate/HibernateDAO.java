package com.blog.hibernate;

import java.util.List;

import org.hibernate.Session;

/*Use Hibernate to implement DAO basic class
 * including basic methods of persistence operation
 */

public class HibernateDAO {

	public Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * Save obj into database
	 */
	public void saveObject(Object obj) {
		getCurrentSession().save(obj);
	}

	/**
	 * update persistence obj
	 */
	public void updateObject(Object obj) {
		getCurrentSession().update(obj);
	}

	/**
	 * use HQL to query
	 */
	public List getObjects(String hsql) {
		List result = getCurrentSession().createQuery(hsql).list();
		return result;
	}

	/**
	 * use HQL to query
	 */
	public Object getObject(String hsql) {
		Object result = getCurrentSession().createQuery(hsql).uniqueResult();
		return result;
	}

	/**
	 * get persistence obj according to id
	 */
	public Object getObject(Class cls, String id) {
		Object result = getCurrentSession().get(cls, id);
		return result;
	}

	/**
	 * delete obj
	 */
	public void deleteObject(Object obj) {
		getCurrentSession().delete(obj);
	}

}
