package com.fxp.bookstore.model.service.impl;

import java.util.List;

import com.fxp.bookstore.model.dao.DaoFactory;
import com.fxp.bookstore.model.entity.Account;
import com.fxp.bookstore.model.entity.Consignee;
import com.fxp.bookstore.model.service.ServiceFactory;

public class UserServiceImpl extends CommonServiceImpl<Account> {

	@Override
	public int save(Account t) {
		return DaoFactory.getDao("user").save(t);
	}

	@Override
	public List<Account> findByConditions(String... conditions) {
		 List<Account> users = DaoFactory.getDao("user").findByConditions(conditions);
		 for(Account account:users){
			 List<Consignee> consignees=ServiceFactory.getService("consignee").findByConditions(account.getId()+"");
			 account.setConsignees(consignees);
		 }
		 return users;
	}

	@Override
	public Account findById(int id) {
		Account account=(Account) DaoFactory.getDao("user").findById(id);
		List<Consignee> consignees = ServiceFactory.getService("consignee").findByConditions(account.getId()+"");
		account.setConsignees(consignees);
		return account;
	}
	
	
}
