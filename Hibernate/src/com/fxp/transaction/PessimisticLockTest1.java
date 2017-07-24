package com.fxp.transaction;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.fxp.common.HibernateSessionFactory;
import com.fxp.transaction.pojo.Account;

public class PessimisticLockTest1 {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		/*����SessionFactory���� hibernate_4.x*/
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		SessionFactory factory=configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		
		
		
		/*ͨ��Session��ɺ����ݿ��CRUD����*/
		Transaction trans=null;
		
		try {
			//��������
			trans=session.beginTransaction();
			
			Account account = (Account)session.get(Account.class, 1L,LockOptions.UPGRADE);
			System.out.println(account);
			System.out.println("����1��ѯ���");
			Thread.sleep(20000);
			account.setBalance(3000.0);
			trans.commit();
			System.out.println("����1�Ѿ��ύ");
			session.close();
		} catch (Exception e) {
			//�ع�����
			trans.rollback();
			e.printStackTrace();
		}finally {
		}

	}

}
