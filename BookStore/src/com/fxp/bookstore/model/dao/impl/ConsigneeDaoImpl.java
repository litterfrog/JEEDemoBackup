package com.fxp.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fxp.bookstore.common.JdbcTemplate;
import com.fxp.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.fxp.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.fxp.bookstore.model.entity.Consignee;

public class ConsigneeDaoImpl extends CommonDaoImpl<Consignee> {

	@Override
	public int save(Consignee t) {
		return JdbcTemplate.update("insert into consignees(id,account_id,full_name,tel,address) values(consignees_seq.nextval,?,?,?,?)", 
								new PreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement pstmt) throws SQLException {
										pstmt.setInt(1, t.getAccountId());
										pstmt.setString(2, t.getFullName());
										pstmt.setString(3, t.getTel());
										pstmt.setString(4, t.getAddress());
										
									}
								});
	}

	@Override
	public Consignee findById(int id) {
		return JdbcTemplate.singleQuery("select * from consignees where id=?", 
								new PreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement pstmt) throws SQLException {
										pstmt.setInt(1, id);
										
									}
								}, 
								createHandler());
	}

	private RowCallBackHandler<Consignee> createHandler() {
		return new RowCallBackHandler<Consignee>() {
			
			@Override
			public Consignee processRow(ResultSet rs) throws SQLException {
				Consignee consignee = new Consignee();
				consignee.setId(rs.getInt("id"));
				consignee.setAddress(rs.getString("address"));
				consignee.setAccountId(rs.getInt("account_id"));
				consignee.setFullName(rs.getString("full_name"));
				consignee.setTel(rs.getString("tel"));
				return consignee;
			}
		};
	}

	@Override
	public List<Consignee> findByConditions(String... conditions) {
		return JdbcTemplate.query("select * from consignees where account_id=?",
								new PreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement pstmt) throws SQLException {
										pstmt.setInt(1, Integer.parseInt(conditions[0]));
										
									}
								}, createHandler());
	}
	
}
