package com.project.EventManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int vendorId;

	private String name;
	private String email;
	private String mobileNo;
	private String services;
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public Vendors(int vendorId, String name, String email, String mobileNo, String services) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.services = services;
	}
	public Vendors() {
		super();
	}
	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", services=" + services + "]";
	}

}