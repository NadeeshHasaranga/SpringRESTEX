package com.springweb.model;


import java.util.Date;

import javax.persistence.Column;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "supplier")
@EntityListeners(AuditingEntityListener.class)
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	

    @Column(name = "supplier_id", nullable = false, unique = true)
    public String supplierid;
    
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
    
    public Supplier() {

    }
    
    public Supplier(String supplier_id, String supplierName) {
        this.supplierid(supplier_id);
        this.setSname(supplierName);
    }
	
	



	private String sname;
	
	
	private String address;
	
	
	private String cname;
	
	
	private String email;
	
	
	private String password;
	
	private int mobile;
	
	

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	
}
