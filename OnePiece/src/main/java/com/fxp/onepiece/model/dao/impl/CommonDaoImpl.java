package com.fxp.onepiece.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxp.onepiece.model.dao.ICommonDao;
@Repository
public class CommonDaoImpl<T> implements ICommonDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> getByConditions(String... conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
