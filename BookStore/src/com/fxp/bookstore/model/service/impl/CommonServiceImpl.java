package com.fxp.bookstore.model.service.impl;

import java.io.Serializable;
import java.util.List;

import com.fxp.bookstore.model.service.ICommonService;

public abstract class CommonServiceImpl<T extends Serializable> implements ICommonService<T> {

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public T findById(int id) {
		return null;
	}

	@Override
	public int save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> findByConditions(String... conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
