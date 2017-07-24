package com.fxp.bookstore.model.service.impl;

import java.util.List;

import com.fxp.bookstore.model.dao.DaoFactory;
import com.fxp.bookstore.model.entity.Order;
import com.fxp.bookstore.model.entity.OrderItem;

public class OrderServiceImpl extends CommonServiceImpl<Order> {

	@Override
	public int save(Order t) {
		int id=DaoFactory.getDao("order").save(t);
		t.setId(id);

		int size=t.getItems().size();
		OrderItem[] items=new OrderItem[size];
		for(int i=0;i<size;i++){
			items[i]=t.getItems().get(i);
			items[i].setOrderId(id);
		}
		int[] arr=DaoFactory.getDao("orderItem").batch(items);
		return id;
	}

	@Override
	public List<Order> findByConditions(String... conditions) {
		List<Order> orders=DaoFactory.getDao("order").findByConditions(conditions);
		for(Order order:orders){
			order.setItems(DaoFactory.getDao("orderItem").findByConditions(order.getId()+""));
		}
		return orders;
	}
	
}
