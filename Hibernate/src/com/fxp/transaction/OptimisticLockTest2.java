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
import com.fxp.transaction.pojo.AccountTimestamp;
import com.fxp.transaction.pojo.AccountVersion;

public class OptimisticLockTest2 {

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
			
//			AccountVersion account = (AccountVersion)session.get(AccountVersion.class, 1L);
			AccountTimestamp account = (AccountTimestamp)session.get(AccountTimestamp.class, 1L);
			System.out.println(account);
			System.out.println("����2��ѯ���");			
			account.setBalance(5000.0);
			Thread.sleep(10000);
			trans.commit();
			System.out.println("����2�Ѿ��ύ");
			session.close();
		} catch (Exception e) {
			//�ع�����
			trans.rollback();
			e.printStackTrace();
		}finally {
		}

	}

}
