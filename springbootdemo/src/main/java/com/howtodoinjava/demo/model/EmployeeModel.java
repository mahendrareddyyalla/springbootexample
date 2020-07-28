package com.howtodoinjava.demo.model;

import java.util.Date;

public class EmployeeModel {
		 
	    public EmployeeModel() {
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastaudit() {
		return lastaudit;
	}
	public void setLastaudit(Date lastaudit) {
		this.lastaudit = lastaudit;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		private String name;
	    private Date lastaudit;
	    private long id;
}
