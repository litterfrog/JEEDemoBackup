package com.fxp.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static Configuration configuration;
	private static SessionFactory factory;
	/*ThreadLocal��ά����һ�����棬������Եĵ�ǰ�̺߳�Session����*/
	private static ThreadLocal<Session> local=new ThreadLocal<>();
	
	static{
		configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		/*����SessionFactory���� hibernate_4.x*/
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		factory=configuration.buildSessionFactory(serviceRegistry);
		
	}
	public static Session getSession() {
		//��õ�ǰ�̰߳󶨵�session����
		/*Session  session=local.get();
		if(session==null){
			session=factory.openSession();
			//���´�����Session������õ�ThreadLocalά���Ļ����У��͵�ǰ�߳̽��а�
			local.set(session);
		}*/
		Session session=factory.getCurrentSession();
		return session;
	}
/*	public static void closeSession() {
		Session session=local.get();
		if(session!=null){
			session.close();
			//��Session����͵�ǰ�߳̽��
			local.set(null);
		}
	}*/
}
