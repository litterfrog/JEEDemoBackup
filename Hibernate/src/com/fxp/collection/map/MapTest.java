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
		images.put("image1","·��1");
		images.put("image2","·��2");
		images.put("image3","·��3");
		images.put("image4","·��4");
		images.put("image5","·��5");
		images.put("image6","·��6");
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
