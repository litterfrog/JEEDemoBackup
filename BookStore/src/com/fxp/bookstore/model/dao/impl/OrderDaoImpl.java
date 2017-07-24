package com.fxp.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.fxp.bookstore.common.JdbcTemplate;
import com.fxp.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.fxp.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.fxp.bookstore.model.entity.Consignee;
import com.fxp.bookstore.model.entity.Order;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

public class OrderDaoImpl extends CommonDaoImpl<Order> {

	@Override
	public int save(Order t) {
		return JdbcTemplate.update("insert into orders(id,consignee_id,shopped_date) values(orders_seq.nextval,?,?)", 
								new PreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement pstmt) throws SQLException {
										pstmt.setInt(1, t.getConsignee().getId());
										pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
										
									}
								});
	}

	@Override
	public List<Order> findByConditions(String... conditions) {
		
		return JdbcTemplate.query("select * from orders where consignee_id in (select id from consignees where account_id=?)",
								new PreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement pstmt) throws SQLException {
										pstmt.setInt(1, Integer.parseInt(conditions[0]));
										
									}
								},
								createHandler());
	}

	private RowCallBackHandler<Order> createHandler() {
		
		return new RowCallBackHandler<Order>() {
			
			@Override
			public Order processRow(ResultSet rs) throws SQLException {
				Order order=new Order();
				order.setId(rs.getInt("id"));
				order.setShoppedDate(rs.getTimestamp("shopped_date"));
				order.setDescription(rs.getString("description"));
				order.setStatus(rs.getString("status"));
				order.setConsignee(new Consignee());
				order.getConsignee().setId(rs.getInt("consignee_id"));	
				return order;
			}
		};
	}
	

}
