package com.fxp.association.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.association.one2one.pojo.Passport;
import com.fxp.association.one2one.pojo.Person;
import com.fxp.common.HibernateSessionFactory;

public class One2oneTest {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("穆罕默德");
		p.setGender("male");
		p.setAge(30);
		
		Passport pp=new Passport();
		pp.setBh("G39494949");
		//双向关联
		p.setPassport(pp);
		pp.setPerson(p);
		
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		
		try {
			trans=session.beginTransaction();
			//保存Person对象同事级联保存Passport对象
//			session.save(p);
			//级联查询
			Person person=(Person) session.get(Person.class, 1L);
			if(person!=null){
				System.out.println(person.toString());
			}
			//级联更新
//			person.setName("小兰");
//			person.setGender("female");
//			person.getPassport().setBh("G00000000");
//			session.update(person);
			
			//级联删除
			session.delete(person);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

}
