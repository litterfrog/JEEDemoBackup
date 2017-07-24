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
			//��������1
			trans=session.beginTransaction();
/*			Student student=(Student) session.get(Student.class, 1L);
			System.out.println(student);*/
			Query query = session.createQuery("from Student");
//			����ʹ�ö�������
			query.setCacheable(true);
			List<Student> list=query.list();
			System.out.println(list.size());
			//�ر�Session1
			trans.commit();
			//�ڶ���get�ǴӶ��������в�ѯ
			session=HibernateSessionFactory.getSession();
			//��������2
			trans=session.beginTransaction();
			/*student=(Student) session.get(Student.class, 1L);
			//read-onlyʱ���»����쳣
//			student.setAge(1);
//			session.update(student);
			System.out.println(student);*/
			query = session.createQuery("from Student");
//			����ʹ�ö�������
			query.setCacheable(true);
			list=query.list();
			System.out.println(list.size());
			//�ر�Session2
			trans.commit();			
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
