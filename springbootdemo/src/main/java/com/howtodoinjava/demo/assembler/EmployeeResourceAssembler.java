package com.howtodoinjava.demo.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
import com.howtodoinjava.demo.mapper.EmployeeMapper;
import com.howtodoinjava.demo.model.EmployeeModel;

@Service
public class EmployeeResourceAssembler extends ResourceAssembler<EmployeeEntity,EmployeeModel> {
	@Autowired(required =false)
	private EmployeeMapper employeeMapper;
	
	/*@Autowired(required=false)
	public EmployeeResourceAssembler(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}*/
	
	@Override
    public EmployeeModel toResource(EmployeeEntity entity) {

        
		EmployeeModel employeeModel = employeeMapper.to(entity);

        // Set the Audit and Security Values.
       /* employee.setAudit(getAudit(entity));
        employee.setSecurity(getSecurity(entity));

        // Build the Links if this is a Web Request.
        if (RequestContextHolder.getRequestAttributes() != null) {
            String link = entityLinks
                    .linkFor(EmployeeEntity.class, entity.getid())
                    .slash(entity.geId())
                    .toString();
            employee.addLink(link);
        }

        
*/        return employeeModel;
    }
}
