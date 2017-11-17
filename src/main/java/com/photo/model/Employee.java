package com.photo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	@Column(name="emp_name")
	private String empName;
	
	@Lob
	@Column(name="photo")
	private byte[] photo;
		
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int emp_id) {
		this.empId = emp_id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
	
}	
	
	
	
	
	
	
	
	
	
	


