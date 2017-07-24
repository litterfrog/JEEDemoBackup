package com.fxp.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class SecondCacheTest {

	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			//启动事务1
			trans=session.beginTransaction();
/*			Student student=(Student) session.get(Student.class, 1L);
			System.out.println(student);*/
			Query query = session.createQuery("from Student");
//			设置使用二级缓存
			query.setCacheable(true);
			List<Student> list=query.list();
			System.out.println(list.size());
			//关闭Session1
			trans.commit();
			//第二次get是从二级缓存中查询
			session=HibernateSessionFactory.getSession();
			//启动事务2
			trans=session.beginTransaction();
			/*student=(Student) session.get(Student.class, 1L);
			//read-only时更新会抛异常
//			student.setAge(1);
//			session.update(student);
			System.out.println(student);*/
			query = session.createQuery("from Student");
//			设置使用二级缓存
			query.setCacheable(true);
			list=query.list();
			System.out.println(list.size());
			//关闭Session2
			trans.commit();			
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
