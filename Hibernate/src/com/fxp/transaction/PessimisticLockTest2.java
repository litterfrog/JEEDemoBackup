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

public class PessimisticLockTest2 {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		/*创建SessionFactory对象 hibernate_4.x*/
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		SessionFactory factory=configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		
		
		
		/*通过Session完成和数据库的CRUD操作*/
		Transaction trans=null;
		
		try {
			//启动事务
			trans=session.beginTransaction();
			System.out.println("事务2正在查询");
			Account account = (Account)session.get(Account.class, 1L,LockOptions.UPGRADE);
			System.out.println(account);
			System.out.println("事务2查询完成");
			account.setBalance(4000.0);
			trans.commit();
			System.out.println("事务2已经提交");
			session.close();
		} catch (Exception e) {
			//回滚事务
			trans.rollback();
			e.printStackTrace();
		}finally {
		}

	}

}
