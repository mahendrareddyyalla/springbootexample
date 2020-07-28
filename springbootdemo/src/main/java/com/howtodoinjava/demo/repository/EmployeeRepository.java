package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
     
 
}
