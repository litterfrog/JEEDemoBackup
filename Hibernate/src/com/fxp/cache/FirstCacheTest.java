package com.fxp.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class FirstCacheTest {

	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//get返回Student的持久化对象
			Student student=(Student) session.get(Student.class, 1L);
			System.out.println(student+" "+student.hashCode());
//			Student student1=(Student) session.get(Student.class, 1L);
//			System.out.println(student1+" "+student1.hashCode());
//			student1.setName("chentao");
//			System.out.println(student+" "+student.hashCode());
//			student1.setName("chentaosha");
			//脏检查， 两个update合并成一条sql
			student.setAddress("moon");
			session.update(student);
			student.setAge(1);
			session.update(student);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
