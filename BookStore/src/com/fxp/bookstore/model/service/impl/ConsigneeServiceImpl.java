package com.fxp.bookstore.model.service.impl;

import java.util.List;

import com.fxp.bookstore.model.dao.DaoFactory;
import com.fxp.bookstore.model.entity.Consignee;

public class ConsigneeServiceImpl extends CommonServiceImpl<Consignee> {

	@Override
	public Consignee findById(int id) {
		return (Consignee) DaoFactory.getDao("consignee").findById(id);
	}

	@Override
	public int save(Consignee t) {
		return DaoFactory.getDao("consignee").save(t);
	}

	@Override
	public List<Consignee> findByConditions(String... conditions) {
		return DaoFactory.getDao("consignee").findByConditions(conditions);
	}


}
