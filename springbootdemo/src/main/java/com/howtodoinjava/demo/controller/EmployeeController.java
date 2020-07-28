package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.model.Student;
import com.howtodoinjava.demo.model.EmployeeModel;
import com.howtodoinjava.demo.repository.EmployeeRepository;
import com.howtodoinjava.demo.service.EmployeeService;
import com.howtodoinjava.demo.assembler.EmployeeResourceAssembler;
import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
import com.howtodoinjava.demo.exception.ResourceNotFoundException;
import com.howtodoinjava.demo.mapper.EmployeeMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Swagger2springbootDemoRestController", description = "REST APIs related to employee Entity!!!!")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	//@Autowired
	EmployeeResourceAssembler employeeResourceAssembler;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	public EmployeeController(EmployeeResourceAssembler employeeResourceAssembler)
	{
		this.employeeResourceAssembler=employeeResourceAssembler;
	}
	//@Autowired(required=false)
	//private EmployeeMapper systemMapper;
	@RequestMapping(method = RequestMethod.GET ,produces = "application/json")
	@ApiOperation("Returns list of all Persons in the system.")
    public ResponseEntity<List<EmployeeEntity>> getEmployees() 
    {
		List<EmployeeEntity> employeelist =  (List<EmployeeEntity>) employeeService.findAllEmployees();
		System.out.println("systemlist"+employeelist);
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return ResponseEntity.ok(employeelist);
    }
	@RequestMapping(value = "/getEmployee/{id}" , method = RequestMethod.GET)
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable(value = "id") Long id) {
		EmployeeEntity Employeelist = employeeService.findEmpId(id);
		if(Employeelist==null) {
			throw new ResourceNotFoundException("emp id not available");
		}
		//EmployeeModel employeeModel=employeeResourceAssembler.toResource(Employeelist);
		//System.out.println("using mapper" +employeeModel);
		System.out.println("system model" +Employeelist);
        //return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
        return ResponseEntity.ok(Employeelist);
        
    }
	@RequestMapping(value ="/storeemployee/{id}" , method = RequestMethod.POST)
	 public ResponseEntity<EmployeeEntity> SaveEmployee(@PathVariable(value = "id") Long id,@RequestBody EmployeeModel systemModel) {
		EmployeeEntity employeeList = employeeRepository.findOne(id);
		if(employeeList != null) {
			employeeList.setName(systemModel.getName());
		EmployeeEntity systemlist2 = employeeRepository.save(employeeList);
		return ResponseEntity.ok(systemlist2);
		}
		EmployeeEntity systemlist1 = new EmployeeEntity();
		systemlist1.setId(systemModel.getId());
		systemlist1.setName(systemModel.getName());
		EmployeeEntity systemlist2 = employeeRepository.save(systemlist1);
        //return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
        return ResponseEntity.ok(systemlist1);
        
    }
}
