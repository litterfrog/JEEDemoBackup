package com.fxp.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fxp.bookstore.common.JdbcTemplate;
import com.fxp.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.fxp.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.fxp.bookstore.model.entity.OrderItem;

public class OrderItemDaoImpl extends CommonDaoImpl<OrderItem> {

	@Override
	public int[] batch(OrderItem... instances) {
		return JdbcTemplate.batch("insert into order_items(order_id,book_id,quantity) values(?,?,?)",
								createSetters(instances));
	}

	
	@Override
	public List<OrderItem> findByConditions(String... conditions) {
		return JdbcTemplate.query("select * from order_items where order_id=?",
				new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, Integer.parseInt(conditions[0]));
						
					}
				},
				createHandler());
	}


	private RowCallBackHandler<OrderItem> createHandler() {
		return new RowCallBackHandler<OrderItem>() {
			
			@Override
			public OrderItem processRow(ResultSet rs) throws SQLException {
				OrderItem item=new OrderItem();
				item.setBookId(rs.getInt("book_id"));
				item.setOrderId(rs.getInt("order_id"));
				item.setQuantity(rs.getInt("quantity"));
				return item;
			}
		};
	}


	private PreparedStatementSetter[] createSetters(OrderItem[] instances) {
		PreparedStatementSetter[] setters=new PreparedStatementSetter[instances.length];
		for(int i=0,len=instances.length;i<len;i++){
			OrderItem item=instances[i];
			setters[i]=new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, item.getOrderId());
					pstmt.setInt(2, item.getBookId());
					pstmt.setInt(3, item.getQuantity());
				}
			};
		}
		return setters;
	}
	
}
