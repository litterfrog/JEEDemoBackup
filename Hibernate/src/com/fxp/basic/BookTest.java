package com.fxp.basic;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.basic.pojo.Book;
import com.fxp.common.HibernateSessionFactory;

public class BookTest {

	public static void main(String[] args) {
		Book book=new Book();
		book.setIsbn("kakka11111sdf33");
		book.setName("book1");
		book.setAuthor("fxp");
		book.setPrice(30.0);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction=null;
		try {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
