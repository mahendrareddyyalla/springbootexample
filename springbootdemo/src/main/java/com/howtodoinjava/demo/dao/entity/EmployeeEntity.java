package com.howtodoinjava.demo.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.howtodoinjava.demo.dao.type.CompanylocationType;
import com.howtodoinjava.demo.model.EmpInfo;
 
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 9021653381093766375L;
	public EmployeeEntity() {
	}
	private String name;
    private Date lastaudit;
    
    /**
     * The to {@link CompanylocationType} for the Company.
     *//*
    @Column(name = "empinfo", columnDefinition = "json")
    @Type(type = "com.howtodoinjava.demo.dao.type.EmpInfoType")
    private EmpInfo empInfo;*/
    public Date getLastaudit() {
        return lastaudit;
    }
    public void setLastaudit(Date lastaudit) {
        this.lastaudit = lastaudit;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
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
     
    public String toString(){
        return id+" | " + name+ " | "+ lastaudit;
    }
     
}