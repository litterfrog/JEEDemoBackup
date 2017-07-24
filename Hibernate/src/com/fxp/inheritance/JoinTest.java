package com.fxp.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;
import com.fxp.inheritance.pojo.BankAccount;
import com.fxp.inheritance.pojo.BillingDetails;
import com.fxp.inheritance.pojo.CreditCard;

public class JoinTest {

	public static void main(String[] args) {

		BankAccount ba=new BankAccount();
		ba.setBankName("China bank");
		ba.setBankSwift("CNB");
		ba.setCreated(new Date(System.currentTimeMillis()));
		ba.setCode("222");
		ba.setOwner("fxp");
		
		CreditCard cc=new CreditCard();
		cc.setType("China");
		cc.setExpYear("2016");
		cc.setExpMonth("3");
		cc.setCreated(new Date(System.currentTimeMillis()));
		cc.setCode("333");
		cc.setOwner("dahuang");
		
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//±£¥Ê
//			session.save(ba);
//			session.save(cc);
			//≤È—Ø
			BillingDetails account=(BillingDetails) session.get(BillingDetails.class,1L);
			System.out.println(account);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
