package com.project.EventManagementSystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sponsors")
public class Sponsors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sponsorId;

	private String name;
	private String email;
	private String mobileno;
	public int getSponsorId() {
		return sponsorId;
	}

    
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
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
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Sponsors(int sponsorId, String name, String email, String mobileno) {
		super();
		this.sponsorId = sponsorId;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
	}
	public Sponsors() {
		super();
	}
	@Override
	public String toString() {
		return "Sponsors [sponsorId=" + sponsorId + ", name=" + name + ", email=" + email + ", mobileno=" + mobileno
				+ "]";
	}

}