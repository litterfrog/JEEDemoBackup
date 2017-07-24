package com.fxp.association.many2many.pojo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;

public class Many2ManyTest {

	public static void main(String[] args) {
		Engineer engineer1=new Engineer();
		engineer1.setName("风萧萧");
		engineer1.setAge(30);
		engineer1.setCompany("楚国");
		engineer1.setGender("male");
		
		Engineer engineer2=new Engineer();
		engineer2.setName("铁树花");
		engineer2.setAge(20);
		engineer2.setCompany("天国");
		engineer2.setGender("female");	
		
		Technology  technology1=new Technology();
		technology1.setName("hibernate");
		technology1.setCategory("software");
		
		Technology  technology2=new Technology();
		technology2.setName("xml");
		technology2.setCategory("software");
		
		Technology  technology3=new Technology();
		technology3.setName("ARM");
		technology3.setCategory("hardware");		

		//建立双向关联
		engineer1.getTechnologies().add(technology1);
		engineer1.getTechnologies().add(technology2);
		engineer2.getTechnologies().add(technology1);
		engineer2.getTechnologies().add(technology3);
		
		technology1.getEngineers().add(engineer1);
		technology1.getEngineers().add(engineer2);
		technology2.getEngineers().add(engineer1);
		technology3.getEngineers().add(engineer2);
		
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//级联保存
//			session.save(engineer1);
//			session.save(engineer2);
			//级联查询
			Engineer engineer=(Engineer) session.get(Engineer.class, 5L);
			System.out.println(engineer);
			//级联删除,多对多无效
//			session.delete(engineer);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
			
		}
	}

}
