package com.project.EventManagementSystem.entities;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
    private int eventId;
	
	private String eventName;
	private String date;
	private String time;
	private String location;
	private int sponsorId;
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sponsors> sponsors;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
	public Event(int eventId, String eventName, String date, String time, String location, int sponsorId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.date = date;
		this.time = time;
		this.location = location;
		this.sponsorId = sponsorId;
	}
	public Event() {
		super();
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", date=" + date + ", time=" + time
				+ ", location=" + location + ", sponsorId=" + sponsorId + "]";
	}
}