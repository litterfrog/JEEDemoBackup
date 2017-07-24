package com.fxp.association.one2many;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.association.one2many.pojo.Order;
import com.fxp.association.one2many.pojo.OrderLine;
import com.fxp.common.HibernateSessionFactory;

public class One2ManyTest {

	public static void main(String[] args) {
		OrderLine ol1=new OrderLine();
		ol1.setProduct("СС��");
		ol1.setPrice(3.5);
		ol1.setQuantity(1L);
		
		OrderLine ol2=new OrderLine();
		ol2.setProduct("������Ƭ");
		ol2.setPrice(4.5);
		ol2.setQuantity(10L);
		
		Order order=new Order();
		order.setOrderedDate(new Date(System.currentTimeMillis()));
		Calendar cl=Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH)+1);
		order.setShippedDate(new Date(cl.getTimeInMillis()));
		//����˫�������ϵ
		order.getOrderlines().add(ol1);
		order.getOrderlines().add(ol2);
		ol1.setOrder(order);
		ol2.setOrder(order);
		
		Double total=0D;
		for(OrderLine ol:order.getOrderlines()){
			total+=ol.getPrice()*ol.getQuantity();
		}
		order.setTotal(total);
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			//��������
			session.save(order);
			//������ѯ
			Order order1=(Order) session.get(Order.class, 1050L);
			System.out.println(order1);
			//��������
//			order1.setOrderedDate(new Date(System.currentTimeMillis()));
//			Double total1=0D;
//			for(OrderLine ol:order1.getOrderlines()){
//				ol.setPrice(5.5);
//				ol.setQuantity(10L);
//				total1+=ol.getPrice()*ol.getQuantity();
//			}
//			order1.setTotal(total1);
//			
//			session.update(order1);
			//����ɾ��
//			session.delete(order1);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

}
