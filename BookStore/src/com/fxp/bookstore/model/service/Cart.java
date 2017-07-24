package com.fxp.bookstore.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fxp.bookstore.model.entity.Book;
import com.fxp.bookstore.model.entity.CartItem;

public class Cart {
	private Map<Integer, CartItem> cart =new HashMap<>();
	public void add(Book book){
		CartItem item=cart.get(book.getId());
		if(item==null){
			cart.put(book.getId(), new CartItem(book));
		}else{
			item.setQuantity(item.getQuantity()+1);
		}
	}
	public void remove(int id){
		cart.remove(id);
	}
	public void changeQuantity(int id,int quantity){
		CartItem item=cart.get(id);
		if(item!=null){
			int count=item.getQuantity()+quantity;
			if(count<1){
				cart.remove(id);
			}else{
				item.setQuantity(count);
			}
		}
	}
	public float getTotal(){
		float total=0;
		for(CartItem item:getItems()){
			total+=item.getTotal();
		}
		return total;
	}
	public Collection<CartItem> getItems() {
		return cart.values();
	}
}
