package com.fxp.bookstore.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static void release(ResultSet rs){
		if(rs!=null){
			try {
				release(rs.getStatement());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Statement statement) {
		if(null!=statement){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void release(Connection conn) {
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
