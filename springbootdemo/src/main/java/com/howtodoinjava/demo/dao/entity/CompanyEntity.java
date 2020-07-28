package com.howtodoinjava.demo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import com.howtodoinjava.demo.dao.type.CompanylocationType;
import com.howtodoinjava.demo.model.Companylocation;

@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity{
	 /**
     * The Id for the company.
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
	
	private String name;
	
	private String type;
	
	/**
     * The to {@link CompanylocationType} for the Company.
     *//*
    @Column(name = "TO_LOCATION", columnDefinition = "json")
    @Type(type = "com.howtodoinjava.demo.dao.type.CompanylocationType")
    private Companylocation companyLocation;
	
	public Companylocation getCompanyLocation() {
		return companyLocation;
	}
	public void setCompanyLocation(Companylocation companyLocation) {
		this.companyLocation = companyLocation;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
