package com.project.EventManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event_planners")
public class EventPlanners {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventplanner_id")
	private int eventPlannerId;
	private String name;
	private String email;
	private int phoneNumber;
	@OneToOne
    @JoinColumn(name = "event_id")
    private Event event;
	
	
	public int getEventPlannerId() {
		return eventPlannerId;
	}
	public void setEventPlannerId(int eventPlannerId) {
		this.eventPlannerId = eventPlannerId;
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public EventPlanners(int eventPlannerId, String name, String email, int phoneNumber, Event event) {
		super();
		this.eventPlannerId = eventPlannerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.event = event;
	}
	public EventPlanners() {
		super();
	}
	@Override
	public String toString() {
		return "EventPlanners [eventPlannerId=" + eventPlannerId + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", event=" + event + "]";
	}

	
}