package com.fxp.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.association.one2many.pojo.Order;
import com.fxp.association.one2many.pojo.OrderLine;
import com.fxp.basic.pojo.Student;
import com.fxp.common.HibernateSessionFactory;
import com.fxp.component.pojo.Address;
import com.fxp.inheritance.pojo.BillingDetails;


public class QueryTest {

	public static void main(String[] args) {
//		queryObject(60025L);
//		queryList();
//		dynamicQuery("banana5",5);
//		SQLQuery();
//		pagingQuery(3,3);//从第四条开始查三条
//		joinQuery();
//		projectionQuery();
//		filterQuery();
//		namedQuery(60025L);
		polymorphismQuery();
	}
	/*return a student*/
	public static void queryObject(Long id){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();

			Query query=session.createQuery("from Student where id=1");
			Student s=(Student) query.uniqueResult();
			System.out.println(s);
			System.out.println("********************");
			query=session.createQuery("from Student where id=:id"); 
			query.setLong("id", id);
			s=(Student) query.uniqueResult();
			System.out.println(":id>>"+s);
			System.out.println("********************");
			query=session.createQuery("from Student s where s.id=?0");
			query.setParameter("0", id);
			s=(Student) query.uniqueResult();
			System.out.println("?0>>"+s);			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	/*return list*/
	@SuppressWarnings("unchecked")
	public static void queryList(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();

			Query query=session.createQuery("from Student");
			List<Student> list=query.list();
			//Iterator iterator=query.iterate();
			System.out.println(list);
			System.out.println("********************");
			query=session.createQuery("from Student where gender=?1 and age between ?2 and ?3"); 
			query.setParameter("1", "female");
			query.setParameter("2", 4);
			query.setParameter("3", 6);
			list=query.list();
			System.out.println(list);
			System.out.println("********************");
			query=session.createQuery("from Student where name like ?1"); 
			query.setParameter("1", "%na8");
			list=query.list();
			System.out.println(list);	
			System.out.println("********************");
			query=session.createQuery("select count(*) from Student");
			Long total=(Long) query.uniqueResult();
			System.out.println("total="+total);
			System.out.println("********************");
			query=session.createQuery("select max(age) from Student");
			Integer maxAge=(Integer) query.uniqueResult();
			System.out.println("maxAge="+maxAge);
			System.out.println("********************");
			query=session.createQuery("select name from Student"); 
			List<String> listName=query.list();
			System.out.println("listName:"+listName);	
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	/*动态查询*/
	public static void dynamicQuery(String name,Integer age){
		String HQL="from Student where 1=1";
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			
			if(name!=null){
				HQL+=" AND NAME ='"+name+"'";
			}
			if(age!=null){
				HQL+=" AND AGE >"+age;
			}
			System.out.println(HQL);
			Query query = session.createQuery(HQL);			
			List<Student> list=query.list();
			System.out.println(list);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	/*原生SQL查询*/
	public static void SQLQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.createSQLQuery("select　* from student order by age");			
			List<Object[]> list=query.list();
			for(Object[] objs:list){
				for(Object o:objs){
					System.out.print(o+"-");
				}
				System.out.println();
			}
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	/*分页查询*/
	public static void pagingQuery(int startPage,int number){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.createQuery("from Student order by age");
			query.setFirstResult(startPage);
			query.setMaxResults(number);
			List<Student> list = query.list();
			System.out.println(list);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}
	
	/*连接查询*/
	public static void joinQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.createQuery("from Order o left outer join o.orderlines ol where ol.order.id=?1");
			query.setParameter("1", 4L);
			List<Object[]> list = query.list();
			for(Object[] os:list){
				Order order=(Order) os[0];
				System.out.println(order);
				OrderLine ol=(OrderLine) os[1];
				System.out.println(ol);
				System.out.println("********************************");
				
			}
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
	/*投影查询*/
	public static void projectionQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.createQuery
					("select c.address.province,c.address.city,c.address.street from Customer c");
			List<Object[]> list = query.list();
			for(Object[] os:list){
				for(Object o:os){
					System.out.print(o+" ");
				}
				System.out.println();
				
			}
			query = session.createQuery
					("select new com.fxp.component.pojo.Address(c.address.province,c.address.city,c.address.street) from Customer c");
			List<Address> list1 = query.list();
			for(Address address:list1){
				System.out.println(address);
			}
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
	/*过滤查询*/
	public static void filterQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Order order=(Order) session.get(Order.class, 4L);
			Query query = session.createFilter
					(order.getOrderlines(),"where this.quantity>=7");
			List<OrderLine> list = query.list();
			System.out.println(list);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
	/*命名查询*/
	public static void namedQuery(Long id){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.getNamedQuery("findStudentById");
			query.setParameter("1", id);
			Student stu = (Student) query.uniqueResult();
			System.out.println(stu);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
	/*多态查询*/
	public static void polymorphismQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			Query query = session.createQuery("from BillingDetails");
			List<BillingDetails> list = query.list();
			System.out.println(list);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
}
