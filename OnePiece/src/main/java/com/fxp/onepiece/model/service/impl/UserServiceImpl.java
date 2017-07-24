package com.fxp.onepiece.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fxp.onepiece.model.dao.ICommonDao;
import com.fxp.onepiece.model.entity.User;
@SuppressWarnings("unchecked")
@Service("userServiceImpl")
public class UserServiceImpl extends CommonServiceImpl<User> {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("userDaoImpl")
	private ICommonDao userDaoImpl;
	@Override	
	public void saveOrUpdate(User user) {
		userDaoImpl.saveOrUpdate(user);
	}
	public User getByName(String name){
		
		return (User) userDaoImpl.getByName(name);
		
	}
}
