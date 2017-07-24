package com.fxp.collection.set;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;

public class SetTest {

	public static void main(String[] args) {
		ItemsSet items=new ItemsSet();
		items.setName("beauty");
		Set<String> images=new HashSet<>();
		images.add("Â·¾¶1");
		images.add("Â·¾¶2");
		images.add("Â·¾¶3");
		items.setImages(images);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
//			session.save(items);
			ItemsSet item=(ItemsSet) session.get(ItemsSet.class, 1);
			System.out.println(item);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

}
