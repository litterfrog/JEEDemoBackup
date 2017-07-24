package com.fxp.bookstore.common;

import java.sql.SQLException;

public final class TransactionManager {
	public static void begin(){
		try {
			ConnectionManager.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			throw new TransactionException(e);
		}
	}
	public static void commit(){
		try {
			ConnectionManager.getConnection().commit();
		} catch (SQLException e) {
			throw new TransactionException(e);
		}finally {
			ConnectionManager.release();
		}
	}
	public static void rollback(){
		try {
			ConnectionManager.getConnection().rollback();
		} catch (SQLException e) {
			throw new TransactionException(e);
		}finally {
			ConnectionManager.release();
		}
	}
	public static class TransactionException extends RuntimeException{
		private static final long serialVersionUID = -4737902499730895626L;

		public TransactionException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TransactionException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public TransactionException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public TransactionException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public TransactionException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
		
	}
}
