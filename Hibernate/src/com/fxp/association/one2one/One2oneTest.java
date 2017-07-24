package com.fxp.association.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.association.one2one.pojo.Passport;
import com.fxp.association.one2one.pojo.Person;
import com.fxp.common.HibernateSessionFactory;

public class One2oneTest {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("�º�Ĭ��");
		p.setGender("male");
		p.setAge(30);
		
		Passport pp=new Passport();
		pp.setBh("G39494949");
		//˫�����
		p.setPassport(pp);
		pp.setPerson(p);
		
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		
		try {
			trans=session.beginTransaction();
			//����Person����ͬ�¼�������Passport����
//			session.save(p);
			//������ѯ
			Person person=(Person) session.get(Person.class, 1L);
			if(person!=null){
				System.out.println(person.toString());
			}
			//��������
//			person.setName("С��");
//			person.setGender("female");
//			person.getPassport().setBh("G00000000");
//			session.update(person);
			
			//����ɾ��
			session.delete(person);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

}
