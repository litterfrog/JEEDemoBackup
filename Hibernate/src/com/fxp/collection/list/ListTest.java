package com.fxp.collection.list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;

public class ListTest {

	public static void main(String[] args) {
		ItemsList items=new ItemsList();
		items.setName("beauty");
		List<String> images=new ArrayList<>();
		images.add("路径1");
		images.add("路径2");
		images.add("路径3");
		images.add("路径4");
		images.add("路径5");
		items.setImages(images);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			session.save(items);
//			ItemsList item=(ItemsList) session.get(ItemsList.class, 1);
//			System.out.println(item);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
