package com.fxp.bookstore.model.dao.impl;

import java.util.List;

import com.fxp.bookstore.model.dao.ICommonDao;

public class CommonDaoImpl<T extends java.io.Serializable> implements ICommonDao<T>{

	@Override
	public int save(T t) {
		return 0;
	}

	@Override
	public int update(T t) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public int delete(T t) {
		return 0;
	}

	@Override
	public T findById(int id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public List<T> findByInstance(T t) {
		return null;
	}

	@Override
	public List<T> find(int start, int count, String order) {
		return null;
	}

	@Override
	public List<T> findByConditions(String... conditions) {
		return null;
	}

	@Override
	public int[] batch(T... instances) {
		return null;
	}


}
