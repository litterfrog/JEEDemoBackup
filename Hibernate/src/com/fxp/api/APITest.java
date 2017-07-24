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
			/*save()����
			 * 
			 * //��ʱ����
//			Student student = new Student(null, "kaka", "kagecheng", "male", 2);
			//�־û�����
			Student student = (Student) session.get(Student.class, 22L);
			System.out.println(student);
//			student.setAddress("gegecheng");
			session.clear();//session.evict(student);//student��Ϊ�������
			session.save(student);*/
			
			/*update����*/
			//��ʱ����
//			Student student = new Student(23L, "kaka", "kagecheng", "male", 2);
//			session.update(student);
			//�־û�����
			//�������
			Student student1 = (Student) session.get(Student.class, 22L);
			session.evict(student1);
			session.update(student1);
			
			/*saveOrUpdate ��*/
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
