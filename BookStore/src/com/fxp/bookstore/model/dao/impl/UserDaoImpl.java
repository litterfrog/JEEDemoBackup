package com.fxp.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fxp.bookstore.common.JdbcTemplate;
import com.fxp.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.fxp.bookstore.model.entity.Account;

import oracle.sql.converter.JdbcCharacterConverters;

public class UserDaoImpl extends CommonDaoImpl<Account> {

	@Override
	public int save(Account t) {
		return JdbcTemplate.update("insert into accounts(id,account,password,email) values(accounts_seq.nextval,?,?,?)", 
					new PreparedStatementSetter() {
						
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setString(1, t.getAccount());
							pstmt.setString(2, t.getPassword());
							pstmt.setString(3, t.getEmail());
							
						}
					});
	}

	@Override
	public Account findById(int id) {
		return JdbcTemplate.singleQuery("select * from accounts where id=?", 
					new PreparedStatementSetter() {
						
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setInt(1, id);
							
						}
					}, createHandler());
	}

	@Override
	public List<Account> findByConditions(String... conditions) {
		//只实现了name的查找
		return JdbcTemplate.query("select * from accounts where account=?", 
					new PreparedStatementSetter() {
						
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setString(1, conditions[0]);
							
						}
					}, createHandler());
	}
	private JdbcTemplate.RowCallBackHandler<Account> createHandler(){
		return new JdbcTemplate.RowCallBackHandler<Account>(){

			@Override
			public Account processRow(ResultSet rs) throws SQLException {
				Account account=new Account();
				account.setAccount(rs.getString("account"));
				account.setId(rs.getInt("id"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setIntegral(rs.getInt("integral"));
				return account;
			}
			
		};
	}
	
}
