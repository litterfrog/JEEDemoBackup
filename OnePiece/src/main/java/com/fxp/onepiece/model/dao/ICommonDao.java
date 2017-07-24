package com.fxp.onepiece.model.dao;

import java.util.List;

public interface ICommonDao <T>{
	void saveOrUpdate(T t);
	List<T> getAll();
	T getById(Long id);
	T getByName(String name);
	List<T> getByConditions(String...conditions);
}
