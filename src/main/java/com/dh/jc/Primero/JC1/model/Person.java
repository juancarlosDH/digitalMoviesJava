package com.dh.jc.Primero.JC1.model;

/**
 * POJO
 * @author jcgljuancarlos
 */
import java.util.Date;

public class Person {
	
	private String name;
	private String last_name;
	private Date birhDate;
	
	public Person(String name, String last_name, Date birhDate) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.birhDate = birhDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirhDate() {
		return birhDate;
	}
	public void setBirhDate(Date birhDate) {
		this.birhDate = birhDate;
	}

}
