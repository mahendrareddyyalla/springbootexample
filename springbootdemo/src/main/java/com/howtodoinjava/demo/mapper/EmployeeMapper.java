package com.howtodoinjava.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
import com.howtodoinjava.demo.model.EmployeeModel;
@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = StringTrimMapper.class)
public interface EmployeeMapper {
	 @Mappings(
	            {
	                    @Mapping(target = "id", ignore = true),
	
	            }
	    )
	    void copy(@MappingTarget EmployeeEntity systemEntity, EmployeeModel systemModel);
	 @Mappings(
            {
         
                    @Mapping(target = "name", source = "name"),
                   
            }
    )
	 EmployeeModel to(EmployeeEntity entity);
}
