package com.howtodoinjava.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;
import com.howtodoinjava.demo.service.EmployeeService;
import com.howtodoinjava.demo.service.event.EmloyeeEvent;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepository employeeRepository;
	/**
     * The {@link ApplicationEventPublisher} to be used.
     */
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	@Autowired
	EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
	this.employeeRepository=employeeRepository;
	}
	
	@Override
	@Transactional
	public EmployeeEntity findEmpId(Long id) {
		// TODO Auto-generated method stub
		
		//eventPublisher.publishEvent(new EmloyeeEvent("mahi","computers"));
		EmployeeEntity systemlist = employeeRepository.findOne(id);
		eventPublisher.publishEvent(new EmloyeeEvent("mahi","computers"));
		return systemlist;
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> systemlist =  (List<EmployeeEntity>) employeeRepository.findAll();
		return systemlist;
	}

}
