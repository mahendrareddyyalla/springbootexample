package com.howtodoinjava.demo.service;

import java.util.List;


import com.howtodoinjava.demo.dao.entity.EmployeeEntity;

public interface EmployeeService {

public List<EmployeeEntity> findAllEmployees();

EmployeeEntity findEmpId(Long id);

}
