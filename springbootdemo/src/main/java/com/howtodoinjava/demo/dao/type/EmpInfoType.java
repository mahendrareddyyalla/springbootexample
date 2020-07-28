package com.howtodoinjava.demo.dao.type;

import com.howtodoinjava.demo.model.EmpInfo;

public class EmpInfoType extends JsonBType {

	@Override
	public Class returnedClass() {
		// TODO Auto-generated method stub
		return EmpInfo.class;
	}

}
