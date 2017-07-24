package com.fxp.onepiece.model.service;

import java.util.List;

public interface ICommonService<T> {
	void saveOrUpdate(T t);
	List<T> getAll();
	T getById(Long id);
	T getByName(String name);
	List<T> getByConditions(String...conditions);
}
