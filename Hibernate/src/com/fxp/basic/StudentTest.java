package com.fxp.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class StudentTest {

	public static void main(String[] args) {
		Student stu =new Student();
		stu.setName("chentao");
		stu.setAddress("shanghai");
		stu.setGender("male");
		stu.setAge(30);
//		Student stu1=new Student();
//		stu1.setAddress("wangxing");
//		stu1.setAge(3);
//		stu1.setGender("male");
//		stu1.setName("wangwang");
		/*����Configuration���󣬲�ȥ��ȡָ����Hibernate���������ļ�hibernate.cfg.xml
		 * ���xml���ṩ���ȡproperty�ļ�*/
/*		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");*/
		
		
		
		//����ӳ���ļ��������xml�������ã��������ظ�����
		//cfg.addResource("com/fxp/basic/pojo/Student.hbm.xml");
		//cfg.addClass(Student.class);
		
		
		
		/*����SessionFactory���� hibernate_3.x*/
		//SessionFactory factory=cfg.buildSessionFactory();
		/*����SessionFactory���� hibernate_4.x*/
/*		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);*/
		
		/*����Session���󣬻�����ݿ����Ӿ�����������ɵ�*/
//		Session session=factory.openSession();
		
		//3.x֮ǰ���Ż���ʽ
		Session session=HibernateSessionFactory.getSession();
		
		
		
		/*ͨ��Session��ɺ����ݿ��CRUD����*/
		Transaction trans=null;
		
		try {
			//��������
			trans=session.beginTransaction();
			//����ѧ������,�����ฺ�����sql
			session.save(stu);

//			session.save(stu1);
			//��ѯ
//			Student student=(Student)session.get(Student.class, 25L);
//			System.out.println(student.toString());
			
			//����
			//student.setAddress("����");
			//session.update(student);
			
			//ɾ��
			//session.delete(student);
			//�ύ����
			trans.commit();
		} catch (Exception e) {
			//�ع�����
			trans.rollback();
			e.printStackTrace();
		}finally {
			/*�ر�session*/
			//HibernateSessionFactory.closeSession();
		}
		
	}

}
