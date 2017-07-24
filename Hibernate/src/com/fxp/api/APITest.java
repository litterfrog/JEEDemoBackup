package com.fxp.api;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class APITest {

	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			/*save()方法
			 * 
			 * //临时对象
//			Student student = new Student(null, "kaka", "kagecheng", "male", 2);
			//持久化对象
			Student student = (Student) session.get(Student.class, 22L);
			System.out.println(student);
//			student.setAddress("gegecheng");
			session.clear();//session.evict(student);//student成为游离对象
			session.save(student);*/
			
			/*update方法*/
			//临时对象
//			Student student = new Student(23L, "kaka", "kagecheng", "male", 2);
//			session.update(student);
			//持久化对象
			//游离对象
			Student student1 = (Student) session.get(Student.class, 22L);
			session.evict(student1);
			session.update(student1);
			
			/*saveOrUpdate 略*/
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
