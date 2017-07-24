package com.fxp.component;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;
import com.fxp.component.pojo.Address;
import com.fxp.component.pojo.Customer;

public class ComponentTest {

	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setName("�����");
		Address address = new Address();
		address.setProvince("��ɽʡ");
		address.setCity("������");
		address.setStreet("˼����");
		customer.setAddress(address);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
//			session.save(customer);
			Customer cust=(Customer) session.get(Customer.class, 1L);
			System.out.println(cust);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
