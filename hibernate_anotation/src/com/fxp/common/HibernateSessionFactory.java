package com.fxp.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static Configuration configuration;
	private static SessionFactory factory;
	/*ThreadLocal中维护了一个缓存，放置配对的当前线程和Session对象*/
	private static ThreadLocal<Session> local=new ThreadLocal<>();
	
	static{
		configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		/*创建SessionFactory对象 hibernate_4.x*/
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		factory=configuration.buildSessionFactory(serviceRegistry);
		
	}
	public static Session getSession() {
		//获得当前线程绑定的session对象
		/*Session  session=local.get();
		if(session==null){
			session=factory.openSession();
			//将新创建的Session对象放置到ThreadLocal维护的缓存中，和当前线程进行绑定
			local.set(session);
		}*/
		Session session=factory.getCurrentSession();
		return session;
	}
/*	public static void closeSession() {
		Session session=local.get();
		if(session!=null){
			session.close();
			//将Session对象和当前线程解绑
			local.set(null);
		}
	}*/
}
