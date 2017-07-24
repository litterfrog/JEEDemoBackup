package com.fxp.onepiece.model.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.fxp.onepiece.model.entity.User;
@Repository("userDaoImpl")
public class UserDaoImpl extends CommonDaoImpl<User> {

	@Override
	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> getByConditions(String... conditions) {
		//以后打算用JPA criteria实现。
		return super.getByConditions(conditions);
	}
	@Override
	public User getByName(String name){
		String hql="FROM User u WHERE u.name=?";
		Query query = getSession().createQuery(hql).setParameter(0, name,StringType.INSTANCE);
		if(query.getResultList()==null||query.getResultList().isEmpty()){
			return null;
		}
		return (User) query.getSingleResult();
	}

}
