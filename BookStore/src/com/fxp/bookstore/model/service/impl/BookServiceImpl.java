package com.fxp.bookstore.model.service.impl;

import java.util.List;

import com.fxp.bookstore.model.dao.DaoFactory;
import com.fxp.bookstore.model.entity.Book;

public class BookServiceImpl extends CommonServiceImpl<Book> {
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		return DaoFactory.getDao("book").findAll();
	}

	@Override
	public Book findById(int id) {
		return (Book) DaoFactory.getDao("book").findById(id);
	}
	
}
