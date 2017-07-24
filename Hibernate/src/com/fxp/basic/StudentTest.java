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
		/*创建Configuration对象，并去读取指定的Hibernate核心配置文件hibernate.cfg.xml
		 * 如果xml不提供则读取property文件*/
/*		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");*/
		
		
		
		//增加映射文件，代码和xml都可配置，但不可重复配置
		//cfg.addResource("com/fxp/basic/pojo/Student.hbm.xml");
		//cfg.addClass(Student.class);
		
		
		
		/*创建SessionFactory对象 hibernate_3.x*/
		//SessionFactory factory=cfg.buildSessionFactory();
		/*创建SessionFactory对象 hibernate_4.x*/
/*		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);*/
		
		/*创建Session对象，获得数据库连接就是在这里完成的*/
//		Session session=factory.openSession();
		
		//3.x之前的优化方式
		Session session=HibernateSessionFactory.getSession();
		
		
		
		/*通过Session完成和数据库的CRUD操作*/
		Transaction trans=null;
		
		try {
			//启动事务
			trans=session.beginTransaction();
			//保存学生对象,方言类负责翻译成sql
			session.save(stu);

//			session.save(stu1);
			//查询
//			Student student=(Student)session.get(Student.class, 25L);
//			System.out.println(student.toString());
			
			//更新
			//student.setAddress("火星");
			//session.update(student);
			
			//删除
			//session.delete(student);
			//提交事务
			trans.commit();
		} catch (Exception e) {
			//回滚事务
			trans.rollback();
			e.printStackTrace();
		}finally {
			/*关闭session*/
			//HibernateSessionFactory.closeSession();
		}
		
	}

}
