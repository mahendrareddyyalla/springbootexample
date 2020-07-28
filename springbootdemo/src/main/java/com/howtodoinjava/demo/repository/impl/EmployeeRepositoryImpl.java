package com.howtodoinjava.demo.repository.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.howtodoinjava.demo.dao.entity.EmployeeEnityRepositoryCustom;
import com.howtodoinjava.demo.dao.entity.EmployeeEntity;

public class EmployeeRepositoryImpl extends QueryDslRepositorySupport implements EmployeeEnityRepositoryCustom{

	public EmployeeRepositoryImpl(){
		super(EmployeeEntity.class);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		// TODO Auto-generated method stub
		return Collections.EMPTY_LIST;
	}

}
