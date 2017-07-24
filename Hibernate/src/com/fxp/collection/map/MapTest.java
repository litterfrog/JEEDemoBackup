package com.fxp.collection.map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fxp.common.HibernateSessionFactory;

public class MapTest {

	public static void main(String[] args) {
		ItemsMap items=new ItemsMap();
		items.setName("beauty");
		Map<String,String> images=new HashMap<>();
		images.put("image1","路径1");
		images.put("image2","路径2");
		images.put("image3","路径3");
		images.put("image4","路径4");
		images.put("image5","路径5");
		images.put("image6","路径6");
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
