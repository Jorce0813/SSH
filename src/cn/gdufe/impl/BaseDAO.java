package cn.gdufe.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	private SessionFactory sessionFactory;
	public BaseDAO() {
		// TODO Auto-generated constructor stub
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		Session session = sessionFactory.openSession();
		return session;
	}
}
