package com.fxp.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxp.springmvc.crud.entities.Department;
import com.fxp.springmvc.crud.entities.Employee;
@Repository
public class EmployeeDao{
	private static Integer initId=1000;
	private static Map<Integer,Employee> employees=null;
	@Autowired
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	static{
		employees=new HashMap<>();
		employees.put(1, new Employee(1,"nameaa","aa@111",1,new Department(1,"aa")));
		employees.put(2, new Employee(2,"namebb","bb@111",0,new Department(1,"bb")));
		employees.put(3, new Employee(3,"namecc","cc@111",1,new Department(1,"cc")));
		employees.put(4, new Employee(4,"namedd","dd@111",0,new Department(1,"dd")));
		employees.put(5, new Employee(5,"nameee","ee@111",1,new Department(1,"ee")));
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	public void delete(Integer id){
		employees.remove(id);
	}
	public void save(Employee employee){
		if(employee.getId()==null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	public Employee getEmployeeById(Integer id) {
		
		return employees.get(id);
	}

}
