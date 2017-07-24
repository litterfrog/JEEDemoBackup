package com.fxp.batch;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class BatchTest {
//性能还是jdbc好，推荐用jdbc
	public static void main(String[] args) {
		long time1=System.currentTimeMillis();
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			for(int i=1;i<=10000;i++){
				Student student= new Student();
				student.setName("banana"+i);
				student.setAddress("gegetown"+i);
				student.setAge(2);
				student.setGender("female");
				session.save(student);
				if(i%50==0){
					session.flush();
					session.clear();
				}
			}

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		long time2=System.currentTimeMillis();
		System.out.println("耗时："+(time2-time1)+"毫秒");

	}

}
