package com.fxp.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fxp.springmvc.crud.entities.Department;
@Repository
public class DepartmentDao{
	private static Map<Integer,Department> departments=null;
	static{
		departments=new HashMap<>();
		departments.put(1, new Department(1,"aa"));
		departments.put(2, new Department(2,"bb"));
		departments.put(3, new Department(3,"cc"));
		departments.put(4, new Department(4,"dd"));
		departments.put(5, new Department(5,"ee"));
	}
	public Collection<Department> getAll(){
		return departments.values();
	}
	public Department getDepartmentById(Integer id){
		return departments.get(id);
	}
}
