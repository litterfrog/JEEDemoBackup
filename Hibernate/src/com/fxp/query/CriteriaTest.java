package com.fxp.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;

public class CriteriaTest {

	public static void main(String[] args) {
//		QBCQuery("bana%",5);
		QBCPagingQuery(2,3);
	}
	/*return a student*/
	public static void QBCQuery(String name,Integer age){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//����һ��Criteria���͵Ķ���
			Criteria criteria=session.createCriteria(Student.class);
			List<Student> list=criteria.list();
			System.out.println(list);
			System.out.println("***************************");
			//��̬��ѯ���趨��ѯ������Ȼ��Ѳ�ѯ�������뵽Criteria�У�
			Criterion c1=Restrictions.like("name", name);
			Criterion c2=Restrictions.gt("age", age);
			criteria.add(c1).add(c2);
			list=criteria.list();
			System.out.println(list);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	/*return a student*/
	public static void QBCPagingQuery(int startPage,int number){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//����һ��Criteria���͵Ķ���
			Criteria criteria=session.createCriteria(Student.class);
			criteria.addOrder(Order.asc("age"));
			criteria.setFirstResult(startPage);
			criteria.setMaxResults(number);
			List<Student> list=criteria.list();
			System.out.println(list);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}

}
