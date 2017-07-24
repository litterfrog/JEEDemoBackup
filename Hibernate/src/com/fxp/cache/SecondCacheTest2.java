package com.fxp.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.association.one2many.pojo.Order;
import com.fxp.common.HibernateSessionFactory;

public class SecondCacheTest2 {

	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			//启动事务1
			trans=session.beginTransaction();
			Order order=(Order) session.get(Order.class, 4L);
			System.out.println(order);
			//关闭Session1
			trans.commit();
			
			//第二次get是从二级缓存中查询
			session=HibernateSessionFactory.getSession();
			//启动事务2
			trans=session.beginTransaction();
			order=(Order) session.get(Order.class, 4L);
			System.out.println(order);
			//关闭Session2
			trans.commit();			
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
